package com.example.week8.endpoint;

import com.example.week8.model.User;
import com.example.week8.service.UserService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.xml.transform.StringSource;

import javax.xml.transform.Source;

@Endpoint
public class UserEndpoint {

    private static final String NAMESPACE_URI =
            "http://example.com/week8";

    private final UserService userService;

    public UserEndpoint(UserService userService) {
        this.userService = userService;
    }

    @PayloadRoot(
            namespace = NAMESPACE_URI,
            localPart = "getUserRequest"
    )
    @ResponsePayload
    public Source getUser(@RequestPayload Source request) {

        User user = userService.getUser();

        String response =
                "<getUserResponse xmlns=\"http://example.com/week8\">" +
                    "<id>" + user.getId() + "</id>" +
                    "<name>" + user.getName() + "</name>" +
                    "<email>" + user.getEmail() + "</email>" +
                "</getUserResponse>";

        return new StringSource(response);
    }
}