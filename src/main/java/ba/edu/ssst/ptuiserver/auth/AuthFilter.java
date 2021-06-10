package ba.edu.ssst.ptuiserver.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ba.edu.ssst.ptuiserver.auth.SecurityConstants.SECRET;

public class AuthFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse= (HttpServletResponse) servletResponse;
        String authHeader = httpRequest.getHeader("Authorization");

        if(httpRequest.getMethod().equals("OPTIONS")){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        if(authHeader!=null){
            String [] authHeaderArr = authHeader.split("Bearer ");
            if(authHeaderArr.length>1 && authHeaderArr[1]!=null) {
                String token = authHeaderArr[1];
                try{
                    Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
                    httpRequest.setAttribute("userId", Integer.parseInt(claims.get("userId").toString()));

                } catch (Exception e){
                    httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "Invalid/expired token");
                    return;
                }
            } else{
                httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "Invalid token format");
                return;
            }
        } else{
            httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "Provide token");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
