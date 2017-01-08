package com.job4sho.service.notification.request;

import com.job4sho.core.Request;
import com.job4sho.model.Job;
import lombok.AllArgsConstructor;
import lombok.Getter;
/**
 * Created by Nsovo on 2016/12/28.
 */
@Getter
@AllArgsConstructor
public class SendJobReminderNotificationRequest extends Request {
    private static final long serialVersionUID = 7523726717467878519L;

    private Job job;
}
