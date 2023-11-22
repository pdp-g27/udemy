package uz.abdurashidov.udemy.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.abdurashidov.udemy.user.dto.UserCreateDto;
import uz.abdurashidov.udemy.user.dto.UserResponseDto;
import uz.abdurashidov.udemy.user.dto.UserUpdateDto;

import java.util.UUID;

@RestController
@RequestMapping( "/user" )
@RequiredArgsConstructor
public class UserController
{
    private final UserService userService;

    @PostMapping( "/register" )
    public ResponseEntity<UserResponseDto> register( @RequestBody @Valid UserCreateDto userCreateDto )
    {
        UserResponseDto responseDto = userService.create( userCreateDto );
        return ResponseEntity.status( HttpStatus.CREATED ).body( responseDto );
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser( @RequestBody @Valid UserCreateDto userCreateDto )
    {
        UserResponseDto responseDto = userService.create( userCreateDto );
        return ResponseEntity.status( HttpStatus.CREATED ).body( responseDto );
    }

    @GetMapping
    public ResponseEntity<Page<UserResponseDto>> getUsers( Pageable pageable, @RequestParam( required = false ) String predicate )
    {
        Page<UserResponseDto> responseDto = userService.getAll( pageable, predicate );
        return ResponseEntity.ok( responseDto );
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<UserResponseDto> getUser( @PathVariable UUID id )
    {
        UserResponseDto responseDto = userService.getById( id );
        return ResponseEntity.ok( responseDto );
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<UserResponseDto> updateUser( @PathVariable UUID id, @Valid @RequestBody UserUpdateDto updateDto )
    {
        UserResponseDto responseDto = userService.update( id, updateDto );
        return ResponseEntity.ok( responseDto );
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<?> deleteUser( @PathVariable UUID id )
    {
        userService.delete( id );
        return ResponseEntity.noContent().build();

    }
}
