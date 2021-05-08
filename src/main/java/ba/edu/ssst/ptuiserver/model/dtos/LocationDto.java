package ba.edu.ssst.ptuiserver.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class LocationDto extends GenericDto<LocationDto>{
    private String city;
    private String area;
}
