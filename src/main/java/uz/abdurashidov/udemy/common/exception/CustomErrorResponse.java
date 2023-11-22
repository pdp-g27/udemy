package uz.abdurashidov.udemy.common.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude( JsonInclude.Include.NON_NULL )
// todo implement generic one
// todo handle sql exceptions and handle validator exceptions
public class CustomErrorResponse
{
    private String message;
    private HttpStatus status;
    private List<String> errors;
    private LocalDateTime timestamp;
}
