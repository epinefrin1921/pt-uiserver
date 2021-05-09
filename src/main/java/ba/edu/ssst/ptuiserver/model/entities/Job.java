package ba.edu.ssst.ptuiserver.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "jobs")
public class Job  extends GenericEntity {

    @Column(name = "jobName")
    private String jobName;

    @Column(name = "jobDescription")
    private String jobDescription;

    @Column(name = "address")
    private String address;

    @Column(name = "startingSalary")
    private int startingSalary;

    @Column(name = "typeOfJob")
    private String typeOfJob;

    @Column(name = "duration")
    private String duration;

    @Column(name = "possibleRemote")
    private boolean possibleRemote;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

}
