package project.cardealership.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import project.cardealership.dto.reponse.ErrorResponse;
import project.cardealership.dto.reponse.ExceptionResponse;
import project.cardealership.exception.AlreadyExistException;
import project.cardealership.exception.BadCredentialException;
import project.cardealership.exception.BadRequestException;
import project.cardealership.exception.NotFoundException;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ExceptionResponse alreadyExistException(AlreadyExistException alreadyExistException){
        return ExceptionResponse
                .builder()
                .httpStatus(HttpStatus.CONFLICT)
                .className(alreadyExistException.getClass().getSimpleName())
                .message(alreadyExistException.getMessage())
                .build();
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse notFoundException(NotFoundException notFoundException){
        return ExceptionResponse
                .builder()
                .className(notFoundException.getClass().getSimpleName())
                .httpStatus(HttpStatus.NOT_FOUND)
                .message(notFoundException.getMessage())
                .build();
    }
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse badRequestException(BadRequestException  badRequestException){
        return ExceptionResponse
                .builder()
                .className(badRequestException.getClass().getSimpleName())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .message(badRequestException.getMessage())
                .build();
    }
    @ExceptionHandler(BadCredentialException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ExceptionResponse badCredentialException(BadCredentialException badCredentialException){
        return ExceptionResponse
                .builder()
                .className(badCredentialException.getClass().getSimpleName())
                .httpStatus(HttpStatus.UNAUTHORIZED)
                .message(badCredentialException.getMessage())
                .build();
    }
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ExceptionResponse accessDeniedException(AccessDeniedException accessDeniedException){
        return ExceptionResponse
                .builder()
                .className(accessDeniedException.getClass().getSimpleName())
                .httpStatus(HttpStatus.FORBIDDEN)
                .message(accessDeniedException.getMessage())
                .build();
    }




    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .toList();

        return ResponseEntity
                .badRequest()
                .body(new ErrorResponse("VALIDATION_ERROR", errors));
    }

}
