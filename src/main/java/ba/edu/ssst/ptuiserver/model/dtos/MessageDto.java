package ba.edu.ssst.ptuiserver.model.dtos;

import ba.edu.ssst.ptuiserver.model.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageDto extends GenericDto{
    private Long id;
    private String content;
    @JsonIgnore
    private User sentBy;
    private UserDto sentByDto;
    private long sentById;
    @JsonIgnore
    private User sentTo;
    private UserDto sentToDto;
    private long sentToId;
}
