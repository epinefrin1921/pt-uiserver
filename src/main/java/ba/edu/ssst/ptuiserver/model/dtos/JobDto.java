package ba.edu.ssst.ptuiserver.model.dtos;

import ba.edu.ssst.ptuiserver.model.entities.Category;
import ba.edu.ssst.ptuiserver.model.entities.Location;
import ba.edu.ssst.ptuiserver.model.entities.User;
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
public class JobDto extends GenericDto{
    private Long id;
    private String jobName;
    private String jobDescription;
    private String address;
    private int startingSalary;
    private String typeOfJob;
    private String duration;
    private boolean possibleRemote;
    private Category category;
    private int categoryId;
    private User owner;
    private int ownerId;
    private Location location;
    private int locationId;
}
