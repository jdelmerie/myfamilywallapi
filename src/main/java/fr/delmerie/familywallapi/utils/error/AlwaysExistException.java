package fr.delmerie.familywallapi.utils.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AlwaysExistException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public AlwaysExistException(String message){
        super(message);
    }
}
