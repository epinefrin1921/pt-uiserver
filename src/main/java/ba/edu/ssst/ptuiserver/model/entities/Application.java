package ba.edu.ssst.ptuiserver.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@Setter
@Getter
@Entity
@Table(
        name="applications"
)
@NoArgsConstructor
@AllArgsConstructor

public class Application extends PrimaryKey implements Serializable,GenericEntity<Application>{

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "cv")
    private String cv;

    @Column(name = "message")
    private String message;

    @Column(name = "photo")
    private String photo;


    @Override
    public void update(Application source) {
        this.job=source.getJob();
        this.user=source.getUser();
        this.cv=source.getCv();
        this.message=source.getMessage();
        this.photo=source.getPhoto();
    }

    @Override
    public Application createNewInstance() {
        Application newInstance = new Application();
        newInstance.update(this);
        return newInstance;
    }
}
