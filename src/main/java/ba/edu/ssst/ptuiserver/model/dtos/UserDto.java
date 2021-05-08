package ba.edu.ssst.ptuiserver.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class UserDto extends GenericDto<UserDto>{

    private String firstName;
    private String lastName;
    private boolean isAdmin;
    private String email;
    private String biography;
    private int contact;
    private int dob;
    private long jmbg;
    private int location;
}
