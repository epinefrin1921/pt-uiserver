package ba.edu.ssst.ptuiserver.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Setter
@Getter
@Entity
@Table(name="job_applications")
@NoArgsConstructor
@AllArgsConstructor
public class JobApplication extends GenericEntity{

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

}
