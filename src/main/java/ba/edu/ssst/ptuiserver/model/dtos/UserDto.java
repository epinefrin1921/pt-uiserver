package ba.edu.ssst.ptuiserver.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {

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
