package ba.edu.ssst.ptuiserver.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto extends GenericDto<CategoryDto>{
    private Long id;
    private String name;
    private String description;
}
