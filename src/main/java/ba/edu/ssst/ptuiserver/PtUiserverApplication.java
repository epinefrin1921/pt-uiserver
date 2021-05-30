package ba.edu.ssst.ptuiserver;

import ba.edu.ssst.ptuiserver.auth.AuthFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PtUiserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(PtUiserverApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean<AuthFilter> filterRegistrationBean(){
		FilterRegistrationBean<AuthFilter> registrationBean = new FilterRegistrationBean<>();
		AuthFilter authFilter = new AuthFilter();
		registrationBean.setFilter(authFilter);
		registrationBean.addUrlPatterns("/location/*", "/application/*", "/category/*", "/job/*", "/message/*",
				"/review/*", "/user/data/*");
		return registrationBean;
	}
}
