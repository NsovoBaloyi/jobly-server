package com.job4sho.service.notification.request;

import com.job4sho.core.Request;
import lombok.AllArgsConstructor;
import lombok.Getter;
/**
 * Created by Nsovo on 2016/12/28.
 */
@Getter
@AllArgsConstructor
public class SendEmailRequest extends Request{
    private static final long serialVersionUID = -5094743467301190188L;

    private String to;

    private String subject;

    private String content;

    private boolean isMultipart;

    private boolean isHtml;
}
