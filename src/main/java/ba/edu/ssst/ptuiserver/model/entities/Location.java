package ba.edu.ssst.ptuiserver.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name="locations")
public class Location extends PrimaryKey implements Serializable,GenericEntity<Location> {

    @Column(name = "city")
    private String city;

    @Column(name = "area")
    private String area;

    @Override
    public void update(Location source) {
     this.city=source.getCity();
     this.area=source.getArea();
    }

    @Override
    public Location createNewInstance() {
        Location newInstance = new Location();
        newInstance.update(this);
        return newInstance;
    }
}
