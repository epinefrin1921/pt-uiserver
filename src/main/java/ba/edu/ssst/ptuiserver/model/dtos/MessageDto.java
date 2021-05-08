package ba.edu.ssst.ptuiserver.model.dtos;

import ba.edu.ssst.ptuiserver.model.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto extends GenericDto<MessageDto>{
    private Long id;
    private String time;
    private String content;
    private User sentBy;
    private int sentById;
    private User postedBy;
    private int postedById;
}
