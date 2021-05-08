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
public class ReviewDto extends GenericDto<ReviewDto>{
    private Long id;
    private double rating;
    private String comment;
    private User user;
    private int userId;
    private User postedBy;
    private int postedById;
}
