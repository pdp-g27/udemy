package uz.abdurashidov.udemy.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBaseDto
{
    @Size( max = 20, min = 3 )
    @NotBlank
    private String firstName;
    @Size( max = 20, min = 3 )
    @NotBlank
    private String lastName;
    @Length( max = 20, min = 3 )
    private String middleName;
    @Pattern( regexp = "^9[012345789][0-9]{7}$" )
    @NotBlank
    private String phoneNumber;
    @Email
    @NotBlank
    private String email;
}
