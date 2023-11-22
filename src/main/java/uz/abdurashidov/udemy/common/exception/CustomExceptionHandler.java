package uz.abdurashidov.udemy.common.exception;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler
{
    @ExceptionHandler( Exception.class )
    public CustomErrorResponse handleExceptions( Exception e )
    {
        log.error( e.getMessage(), e );
        return buildErrorResponse( "Something is wrong, please repeat later", HttpStatus.INTERNAL_SERVER_ERROR );
    }

    public CustomErrorResponse buildErrorResponse( String message, HttpStatus status )
    {
        return buildErrorResponse( message, status, null );
    }

    public CustomErrorResponse buildErrorResponse( String message, HttpStatus status, List<String> errors )
    {
        return new CustomErrorResponse( message, status, errors, LocalDateTime.now() );
    }

    @ExceptionHandler( EntityNotFoundException.class )
    public ResponseEntity<CustomErrorResponse> handleEntityNotFoundException( EntityNotFoundException e )
    {
        log.error( e.getMessage(), e );
        return ResponseEntity
            .status( HttpStatus.NOT_FOUND )
            .body( buildErrorResponse( e.getMessage(), HttpStatus.NOT_FOUND ) );
    }
}
