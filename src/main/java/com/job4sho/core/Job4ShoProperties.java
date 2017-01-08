package com.job4sho.core;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.cors.CorsConfiguration;


/**
 * Created by Nsovo on 2016/12/29.
 */
@Getter
@ConfigurationProperties(prefix = "job4sho", ignoreUnknownFields = false)
public class Job4ShoProperties {

    private final CorsConfiguration cors = new CorsConfiguration();
    private final Frontend frontend = new Frontend();
    private final Mail mail = new Mail();
    private final Security security = new Security();

    @Getter
    @Setter
    public static class Frontend {

        private String baseUrl = "localhost:8080";
    }

    @Getter
    @Setter
    public static class Mail {

        private String from = "";
    }

    @Getter
    public static class Security {

        private final Authentication authentication = new Authentication();

        @Getter
        public static class Authentication {

            private final Oauth oauth = new Oauth();

            @Getter
            @Setter
            public static class Oauth {

                private String clientid;

                private String secret;

                private int tokenValidityInSeconds = 1800;
            }
        }
    }


}
