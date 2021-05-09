package ba.edu.ssst.ptuiserver.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "reviews")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review extends GenericEntity{

    @Column(name = "rating")
    private double rating;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "postedby_id")
    private User postedBy;

}
