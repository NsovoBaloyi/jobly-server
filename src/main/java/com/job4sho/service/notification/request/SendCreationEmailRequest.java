package com.job4sho.service.notification.request;

import com.job4sho.core.Request;
import com.job4sho.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
/**
 * Created by Nsovo on 2016/12/29.
 */
@Getter
@AllArgsConstructor
public class SendCreationEmailRequest extends Request {
    private static final long serialVersionUID = -93307460988060440L;

    private User user;
}
