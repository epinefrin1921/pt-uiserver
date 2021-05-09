package ba.edu.ssst.ptuiserver.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name="categories")
@NoArgsConstructor
@AllArgsConstructor
public class Category extends PrimaryKey implements Serializable,GenericEntity<Category>{

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Override
    public void update(Category source) {
     this.name=source.getName();
     this.description=source.getDescription();
    }

    @Override
    public Category createNewInstance() {
        Category newInstance = new Category();
        newInstance.update(this);
        return newInstance;
    }
}
