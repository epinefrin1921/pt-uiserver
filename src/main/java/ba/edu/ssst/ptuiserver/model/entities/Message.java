package ba.edu.ssst.ptuiserver.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Table(name = "messages")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message extends GenericEntity{

    @Column(name = "time")
    private String time;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "sentby_id")
    private User sentBy;

    @ManyToOne
    @JoinColumn(name = "postedby_id")
    private User postedBy;

}
