package com.jobly.notification;

/**
 * Created by Nsovo on 2016/12/23.
 */
public interface INotification {

    public SendEmailResponse sendEmail(SendEmailRequest request) throws EmailNotSentException;

    public SendActivationEmailResponse sendActivationEmail(SendActivationEmailRequest request) throws EmailNotSentException;

    public SendCreationEmailResponse sendCreationEmail(SendCreationEmailRequest request) throws EmailNotSentException;

    public SendPasswordResetMailResponse sendPasswordResetMail(SendPasswordResetMailRequest request) throws EmailNotSentException;

}
