package ba.edu.ssst.ptuiserver.model.dtos;

import ba.edu.ssst.ptuiserver.model.entities.Job;
import ba.edu.ssst.ptuiserver.model.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDto extends GenericDto<ApplicationDto>{
    private Long id;
    private int jobId;
    private Job job;
    private int userId;
    private User user;
    private String cv;
    private String message;
    private String photo;
}
