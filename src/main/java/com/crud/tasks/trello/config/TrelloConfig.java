package com.crud.tasks.trello.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class TrelloConfig {

    @Value("${trello.api.endpoint.prod}")
    private String trelloApiEndpoint;

    @Value("${trello.app.key}")
    private String trelloAppKey;

    @Value("${trello.app.token}")
    private String trelloToken;

    @Value("${trello.app.username}")
    private String trelloUsername;

    public String getTrelloApiEndpoint() {
        return trelloApiEndpoint;
    }

    public String getTrelloAppKey() {
        return trelloAppKey;
    }

    public String getTrelloToken() {
        return trelloToken;
    }

    public String getTrelloUsername() {
        return trelloUsername;
    }
}
