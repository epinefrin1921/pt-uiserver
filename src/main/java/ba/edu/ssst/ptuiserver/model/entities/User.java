package ba.edu.ssst.ptuiserver.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Table(name = "users")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends GenericEntity{

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
    private String contact;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "jmbg")
    private String jmbg;

    @Column(name = "token")
    private String token;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

}

