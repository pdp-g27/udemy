package uz.abdurashidov.udemy.group;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import uz.abdurashidov.udemy.common.service.GenericDtoMapper;
import uz.abdurashidov.udemy.group.dto.GroupCreateDto;
import uz.abdurashidov.udemy.group.dto.GroupResponseDto;
import uz.abdurashidov.udemy.group.dto.GroupUpdateDto;
import uz.abdurashidov.udemy.group.entity.Group;

@RequiredArgsConstructor
@Component
public class GroupDtoMapper extends GenericDtoMapper<Group, GroupCreateDto, GroupUpdateDto, GroupResponseDto> {
    private final ModelMapper mapper;

    @Override
    public Group toEntity(GroupCreateDto groupCreateDto) {
        return mapper.map(groupCreateDto, Group.class);
    }

    @Override
    public GroupResponseDto toResponseDto(Group group) {
        return mapper.map(group, GroupResponseDto.class);
    }

    @Override
    public void update(GroupUpdateDto groupUpdateDto, Group group) {
        mapper.map(groupUpdateDto, group);
    }
}
