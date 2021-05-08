package ba.edu.ssst.ptuiserver.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@Table(
        name = "messages"
)
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message extends PrimaryKey implements Serializable,GenericEntity<Message>{

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


    @Override
    public void update(Message source) {
        this.time=source.getTime();
        this.content=source.getContent();
        this.sentBy=source.getSentBy();
        this.postedBy=source.getPostedBy();
    }

    @Override
    public Message createNewInstance() {
        Message newInstance = new Message();
        newInstance.update(this);
        return newInstance;
    }
}
