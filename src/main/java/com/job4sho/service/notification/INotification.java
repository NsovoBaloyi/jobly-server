package com.job4sho.service.notification;

import com.job4sho.service.notification.exception.*;
import com.job4sho.service.notification.request.*;
import com.job4sho.service.notification.response.*;

/**
 * Created by Nsovo on 2016/12/23.
 */
public interface INotification {

    SendEmailResponse sendEmail(SendEmailRequest request) throws EmailNotSendException;

    SendActivationEmailResponse sendActivationEmail(SendActivationEmailRequest request) throws EmailNotSendException;

    SendBroadcastEmailResponse sendBroadcastEmail(SendBroadcastEmailRequest sendBroadcastEmailRequest) throws EmailNotSendException;

    SendCreationEmailResponse sendCreationEmail(SendCreationEmailRequest request) throws EmailNotSendException;

    SendJobReminderNotificationResponse sendJobReminderNotification(SendJobReminderNotificationRequest request) throws EmailNotSendException;

    SendPasswordResetEmailResponse sendPasswordResetEmail(SendPasswordResetEmailRequest request) throws EmailNotSendException;

    SendPaymentConfirmationResponse sendPaymentConfirmationEmail(SendPaymentConfirmationRequest request) throws EmailNotSendException, PaymentFailedException;
}
