package ba.edu.ssst.ptuiserver.model.dtos;

import ba.edu.ssst.ptuiserver.model.entities.Job;
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
public class JobApplicationDto extends GenericDto{
    private Long id;
    private long jobId;
    @JsonIgnore
    private Job job;
    private JobDto jobDto;
    private long userId;
    @JsonIgnore
    private User user;
    private UserDto userDto;
    private String cv;
    private String message;
    private String photo;
}
