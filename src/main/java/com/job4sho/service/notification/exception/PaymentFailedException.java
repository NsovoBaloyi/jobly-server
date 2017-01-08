package com.job4sho.service.notification.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Nsovo on 2016/12/29.
 */
@ResponseStatus(value= HttpStatus.PRECONDITION_FAILED, reason = "Duplicate Username")
public class PaymentFailedException extends Exception {
    public PaymentFailedException() {
    }

    public PaymentFailedException(String message) {
        super(message);
    }

    public PaymentFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public PaymentFailedException(Throwable cause) {
        super(cause);
    }

    public PaymentFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
