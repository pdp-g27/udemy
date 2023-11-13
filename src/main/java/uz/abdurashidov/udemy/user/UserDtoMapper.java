package uz.abdurashidov.udemy.user;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import uz.abdurashidov.udemy.common.service.GenericDtoMapper;
import uz.abdurashidov.udemy.user.dto.UserCreateDto;
import uz.abdurashidov.udemy.user.dto.UserResponseDto;
import uz.abdurashidov.udemy.user.dto.UserUpdateDto;
import uz.abdurashidov.udemy.user.entity.User;

@Component
@RequiredArgsConstructor
public class UserDtoMapper extends GenericDtoMapper<User, UserCreateDto, UserUpdateDto, UserResponseDto> {
    private final ModelMapper mapper;

    @Override
    public User toEntity(UserCreateDto userCreateDto) {
        return mapper.map(userCreateDto, User.class);
    }

    @Override
    public UserResponseDto toResponseDto(User user) {
        return mapper.map(user, UserResponseDto.class);
    }

    @Override
    public void update(UserUpdateDto updateDto, User user) {
        mapper.map(updateDto, user);
    }
}
