package com.crud.tasks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

@Service
public class MailCreatorService {

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

}
