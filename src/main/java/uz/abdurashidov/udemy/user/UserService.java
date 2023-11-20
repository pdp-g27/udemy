package uz.abdurashidov.udemy.user;

import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.abdurashidov.udemy.common.service.GenericCrudService;
import uz.abdurashidov.udemy.user.dto.UserCreateDto;
import uz.abdurashidov.udemy.user.dto.UserResponseDto;
import uz.abdurashidov.udemy.user.dto.UserUpdateDto;
import uz.abdurashidov.udemy.user.entity.User;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
@Getter
public class UserService extends GenericCrudService<User, UUID, UserCreateDto, UserUpdateDto, UserResponseDto> {
    private final UserDtoMapper mapper;
    private final UserRepository repository;
    private final Class<User> entityClass = User.class;
}
