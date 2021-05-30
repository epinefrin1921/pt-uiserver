package ba.edu.ssst.ptuiserver.model.dtos;

import ba.edu.ssst.ptuiserver.model.entities.Location;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto extends GenericDto{
    private Long id;
    private String firstName;
    private String lastName;
    private boolean isAdmin;
    private String email;
    private String biography;
    private String contact;
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dob;
    private String jmbg;
    @JsonIgnore
    private Location location;
    private LocationDto locationDto;
    private long locationId;
    private String password;
}
