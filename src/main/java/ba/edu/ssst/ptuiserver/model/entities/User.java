package ba.edu.ssst.ptuiserver.model.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(
        name = "users"
)
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends PrimaryKey implements Serializable,GenericEntity<User> {

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

    @Override
    public void update(User source) {
     this.firstName=source.getFirstName();
     this.lastName=source.getLastName();
     this.isAdmin=source.isAdmin();
     this.email=source.getEmail();
     this.biography=source.getBiography();
     this.contact=source.getContact();
     this.dob=source.getDob();
     this.jmbg=source.getJmbg();
     this.location=source.getLocation();
    }

    @Override
    public User createNewInstance() {
        User newInstance = new User();
        newInstance.update(this);
        return newInstance;
    }
}

