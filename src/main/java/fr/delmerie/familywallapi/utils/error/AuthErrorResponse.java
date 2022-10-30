package fr.delmerie.familywallapi.utils.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class AuthErrorResponse extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AlwaysExistException.class)
    public final ResponseEntity<ErrorResponse> userExistAlready(AlwaysExistException exception, WebRequest request){
        List<String> details = new ArrayList<>();
        details.add(exception.getLocalizedMessage());
        String BAD_REQUEST = "BAD_REQUEST";
        ErrorResponse error = new ErrorResponse(BAD_REQUEST, details);
        return  new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
