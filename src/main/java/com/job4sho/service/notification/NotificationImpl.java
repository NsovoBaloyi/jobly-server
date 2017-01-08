package com.job4sho.service.notification;

import com.job4sho.core.JoblyProperties;
import com.job4sho.service.notification.exception.*;
import com.job4sho.service.notification.request.*;
import com.job4sho.service.notification.response.*;
import javax.inject.Inject;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.CharEncoding;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import java.util.Locale;

/**
 * Created by Nsovo on 2016/12/23.
 */

@Service
public class NotificationImpl implements INotification {

    private static final String USER = "people";
    private static final String BASE_URL = "baseUrl";

    @Inject
    private JavaMailSender javaMailSender;

    @Inject
    private MessageSource messageSource;

    @Inject
    private SpringTemplateEngine templateEngine;

    @Inject
    private JoblyProperties properties;

    @Override
    public SendEmailResponse sendEmail(SendEmailRequest request) throws EmailNotSendException {
        log.debug("Send e-mail[multipart '{}' and html '{}'] to '{}' with subject '{}' and content={}",
                request.isMultipart(), request.isHtml(), request.getTo(), request.getSubject(), request.getContent());

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, request.isMultipart(), CharEncoding.UTF_8);
            message.setTo(request.getTo());
            message.setFrom(properties.getMail().getFrom());
            message.setSubject(request.getSubject());
            message.setText(request.getContent(), request.isHtml());
            javaMailSender.send(mimeMessage);
            log.debug("Sent e-mail to User '{}'", request.getTo());
        } catch (Exception e) {
            log.warn("E-mail could not be sent to people '{}', exception is: {}", request.getTo(), e.getMessage());
            throw new EmailNotSendException(e.getMessage());
        }
        return new SendEmailResponse();
    }

    @Override
    public SendBroadcastEmailResponse sendBroadcastEmail(SendBroadcastEmailRequest sendBroadcastEmailRequest) throws EmailNotSendException{

    }

    @Override
    public SendActivationEmailResponse sendActivationEmail(SendActivationEmailRequest request) throws EmailNotSendException {
        log.debug("Sending activation e-mail to '{}'", request.getUser().getEmail());
        Locale locale = Locale.ENGLISH;
        Context context = new Context(locale);
        context.setVariable(USER, request.getUser());
        context.setVariable(BASE_URL, properties.getFrontend().getBaseUrl());
        String content = templateEngine.process("activationEmail", context);
        String subject = messageSource.getMessage("email.activation.title", null, locale);
        sendEmail(new SendEmailRequest(request.getUser().getEmail(), subject, content, false, true));
        return new SendActivationEmailResponse();
    }

    @Override
    public SendCreationEmailResponse sendCreationEmail(SendCreationEmailRequest request) throws EmailNotSendException {
        log.debug("Sending creation e-mail to '{}'", request.getUser().getEmail());
        Locale locale = Locale.ENGLISH;
        Context context = new Context(locale);
        context.setVariable(USER, request.getUser());
        context.setVariable(BASE_URL, properties.getFrontend().getBaseUrl());
        String content = templateEngine.process("creationEmail", context);
        String subject = messageSource.getMessage("email.activation.title", null, locale);
        sendEmail(new SendEmailRequest(request.getUser().getEmail(), subject, content, false, true));
        return new SendCreationEmailResponse();
    }

    @Override
    public SendPasswordResetEmailResponse sendPasswordResetEmail(SendPasswordResetEmailRequest request) throws EmailNotSendException {
        log.debug("Sending password reset e-mail to '{}'", request.getUser().getEmail());
        Locale locale = Locale.ENGLISH;
        Context context = new Context(locale);
        context.setVariable(USER, request.getUser());
        context.setVariable(BASE_URL, properties.getFrontend().getBaseUrl());
        String content = templateEngine.process("passwordResetEmail", context);
        String subject = messageSource.getMessage("email.reset.title", null, locale);
        sendEmail(new SendEmailRequest(request.getUser().getEmail(), subject, content, false, true));
        return new SendPasswordResetEmailResponse();
    }

    @Override
    public SendJobReminderNotificationResponse sendJobReminderNotification(SendJobReminderNotificationRequest request) throws EmailNotSendException{
        log.debug("Sending job reminder email to '{}'", request.getUser().getEmail());
        Locale locale = Locale.ENGLISH;
        Context context = new Context(locale);
        context.setVariable(USER, request.getUser());
        context.setVariable(BASE_URL, properties.getFrontend().getBaseUrl());
        String content = templateEngine.process("passwordResetEmail", context);
        String subject = messageSource.getMessage("email.reset.title", null, locale);
        sendEmail(new SendEmailRequest(request.getUser().getEmail(), subject, content, false, true));

        return new SendJobReminderNotificationResponse();
    }

    @Override
    public SendPaymentConfirmationResponse sendPaymentConfirmationEmail(SendPaymentConfirmationRequest request) throws EmailNotSendException, PaymentFailedException{
        return  new SendPaymentConfirmationResponse();
    }



}
