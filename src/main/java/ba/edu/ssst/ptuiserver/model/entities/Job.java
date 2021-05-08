package ba.edu.ssst.ptuiserver.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "jobs")
public class Job extends PrimaryKey implements Serializable,GenericEntity<Job> {

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

    @Override
    public void update(Job source) {
     this.jobName=source.getJobName();
     this.jobDescription=source.getJobDescription();
     this.address=source.getAddress();
     this.startingSalary=source.getStartingSalary();
     this.typeOfJob=source.getTypeOfJob();
     this.duration=source.getDuration();
     this.possibleRemote= source.isPossibleRemote();
     this.category=source.getCategory();
     this.owner=source.getOwner();
     this.location=source.getLocation();
    }

    @Override
    public Job createNewInstance() {
        Job newInstance = new Job();
        newInstance.update(this);
        return newInstance;
    }
}
