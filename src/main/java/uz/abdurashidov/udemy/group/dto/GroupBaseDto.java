package uz.abdurashidov.udemy.group.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.abdurashidov.udemy.group.entity.GroupType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupBaseDto {
    private String name;
    private GroupType groupType;
}
