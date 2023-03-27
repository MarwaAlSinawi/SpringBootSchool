package com.codeline.API.School.First.FirstSchoolAPIProject.Slack;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import static java.awt.SystemColor.text;
@Component
public class SlackClient {
    public String sendMessage(String text) {
     return WebClient.create().post()
                .uri("")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new SlackPayload(text))
            .retrieve()
                .bodyToMono(String.class)
                .block();
}

}
