package ba.edu.ssst.ptuiserver.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Getter
@Setter
@Entity
@Table(name = "jobs")

public class Jobs extends PrimaryKey {

    @Column(name = "jobName")
    private String jobName;

    @Column(name = "jobDescription")
    private String jobDescription;

    @Column(name = "jobLocation")
    private int jobLocation;

    @Column(name = "startingSalary")
    private int startingSalary;

    @Column(name = "typeOfJob")
    private String typeOfJob;

    @Column(name = "duration")
    private String duration;

    @Column(name = "possibleRemote")
    private boolean possibleRemote;

    @Column(name = "categoryId")
    private int categoryId;

    @Column(name = "ownerId")
    private int ownerId;

    @Column(name = "cityId")
    private int cityID;
}
