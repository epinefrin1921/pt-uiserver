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
public class ReviewDto extends GenericDto{
    private Long id;
    private double rating;
    private String comment;
    @JsonIgnore
    private User user;
    private long userId;
    private UserDto userDto;
    @JsonIgnore
    private User postedBy;
    private long postedById;
    private UserDto postedByDto;
}
