package uz.abdurashidov.udemy.group;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.abdurashidov.udemy.common.service.GenericCrudService;
import uz.abdurashidov.udemy.group.dto.GroupCreateDto;
import uz.abdurashidov.udemy.group.dto.GroupResponseDto;
import uz.abdurashidov.udemy.group.dto.GroupUpdateDto;
import uz.abdurashidov.udemy.group.entity.Group;

import java.util.UUID;

@Getter
@Service
@RequiredArgsConstructor
public class GroupService extends GenericCrudService<Group, UUID, GroupCreateDto, GroupUpdateDto, GroupResponseDto>
{
    private final GroupDtoMapper mapper;
    private final GroupRepository repository;
    private final Class<Group> entityClass = Group.class;
}
