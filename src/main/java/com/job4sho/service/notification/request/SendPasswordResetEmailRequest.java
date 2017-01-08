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
public class SendPasswordResetEmailRequest extends Request {
    private static final long serialVersionUID = -5067308555600041955L;

    private User user;

    public SendPasswordResetEmailRequest(User u){
        this.user = u;

    }

    public User getUser(){
        return  this.user;
    }

}
