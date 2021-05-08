package ba.edu.ssst.ptuiserver.model.dtos;

import ba.edu.ssst.ptuiserver.model.entities.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends GenericDto<UserDto>{
    private Long id;
    private String firstName;
    private String lastName;
    private boolean isAdmin;
    private String email;
    private String biography;
    private int contact;
    private int dob;
    private long jmbg;
    private Location location;
    private int locationId;
}
