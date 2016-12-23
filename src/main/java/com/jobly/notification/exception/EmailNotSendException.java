package com.jobly.notification.exception;

/**
 * Created by Nsovo on 2016/12/23.
 */
public class EmailNotSendException extends Exception {

    public EmailNotSendException() {
    }

    public EmailNotSendException(String message) {
        super(message);
    }

    public EmailNotSendException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailNotSendException(Throwable cause) {
        super(cause);
    }

    public EmailNotSendException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
