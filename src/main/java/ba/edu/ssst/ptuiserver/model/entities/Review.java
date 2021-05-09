package ba.edu.ssst.ptuiserver.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "reviews")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review extends PrimaryKey implements Serializable,GenericEntity<Review>{

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

    @Override
    public void update(Review source) {
     this.rating=source.getRating();
     this.comment=source.getComment();
     this.user=source.getUser();
     this.postedBy=source.getPostedBy();
    }

    @Override
    public Review createNewInstance() {
       Review newInstance = new Review();
        newInstance.update(this);
        return newInstance;
    }
}
