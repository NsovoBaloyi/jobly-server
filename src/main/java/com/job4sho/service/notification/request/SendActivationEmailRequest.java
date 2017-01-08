package com.job4sho.service.notification.request;

import com.job4sho.core.Request;
import com.job4sho.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
/**
 * Created by Nsovo on 2016/12/28.
 */
@Getter
@AllArgsConstructor
public class SendActivationEmailRequest extends Request{
    private static final long serialVersionUID = -9140245267970728937L;

    private User user;
}
