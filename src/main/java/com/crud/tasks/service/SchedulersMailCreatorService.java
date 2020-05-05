package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.config.CompanyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class SchedulersMailCreatorService{

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private CompanyConfig companyConfig;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String buildSchedulerEmail(String message) {

        Context scheduleContext = new Context();
        scheduleContext.setVariable("message", message);
        scheduleContext.setVariable("tasks_url", "http://localhost:8888/tasks_frontend/");
        scheduleContext.setVariable("button", "Visit website");
        scheduleContext.setVariable("admin_name", adminConfig.getAdminName());
        scheduleContext.setVariable("preview_message", "Once a day info message");
        scheduleContext.setVariable("company_name", companyConfig.getCompanyName());
        scheduleContext.setVariable("company_goal", companyConfig.getCompanyGoal());
        scheduleContext.setVariable("company_email", companyConfig.getCompanyEmail());
        scheduleContext.setVariable("company_phone", companyConfig.getCompanyPhone());
        scheduleContext.setVariable("show_button", false);
        scheduleContext.setVariable("is_friend", false);
        scheduleContext.setVariable("admin_config", adminConfig);
        scheduleContext.setVariable("goodbye_message", "Bye bye");
        return templateEngine.process("mail/email-scheduler", scheduleContext);
    }
}
