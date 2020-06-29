package com.crud.tasks.trello.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class TrelloAdminConfig {

    @Value("${user.name}")
    private String userName;

    @Value("${user.mail}")
    private String userMail;

    @Value("${info.company.name}")
    private String companyName;

    @Value("${info.company.email}")
    private String companyMail;
}
