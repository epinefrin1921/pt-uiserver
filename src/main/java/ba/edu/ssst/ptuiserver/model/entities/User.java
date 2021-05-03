package ba.edu.ssst.ptuiserver.model.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(
        name = "users"
)
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends PrimaryKey {

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "isAdmin")
    private boolean isAdmin;

    @Column(name = "email")
    private String email;

    @Column(name = "biography")
    private String biography;

    @Column(name = "contact")
    private int contact;

    @Column(name = "dob")
    private int dob;

    @Column(name = "jmbg")
    private long jmbg;

    @Column(name = "location")
    private int location;
}

