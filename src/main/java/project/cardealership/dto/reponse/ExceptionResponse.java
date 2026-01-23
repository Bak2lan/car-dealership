package project.cardealership.dto.reponse;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
@Setter
public class ExceptionResponse {
    private HttpStatus httpStatus;
    private String message;
    private String className;

}
