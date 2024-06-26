package org.Edu.navigator.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DuplicateEmailException extends  RuntimeException{
    String message;
    public DuplicateEmailException(String message){
        super(message);
        this.message = message;
    }
}
