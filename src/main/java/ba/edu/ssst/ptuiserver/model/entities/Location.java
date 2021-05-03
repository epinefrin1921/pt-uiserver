package ba.edu.ssst.ptuiserver.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Getter
@Setter
@Entity
@Table(name="locations")

public class Location extends PrimaryKey {

    @Column(name = "city")
    private String city;

    @Column(name = "area")
    private String area;

}
