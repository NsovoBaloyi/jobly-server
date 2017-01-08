package com.job4sho.service.people.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**

 * @author
 * @version 1.0.0
 */

@ResponseStatus(value= HttpStatus.PRECONDITION_FAILED, reason = "User not activated")
public class UserNotActivatedException extends Exception {


    private static final long serialVersionUID = -8166015765768850836L;

    public UserNotActivatedException() {
        super();
    }

    public UserNotActivatedException(String message) {
        super(message);
    }

    public UserNotActivatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotActivatedException(Throwable cause) {
        super(cause);
    }

    protected UserNotActivatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
