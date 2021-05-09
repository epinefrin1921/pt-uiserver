package ba.edu.ssst.ptuiserver.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name="categories")
@NoArgsConstructor
@AllArgsConstructor
public class Category extends GenericEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

}
