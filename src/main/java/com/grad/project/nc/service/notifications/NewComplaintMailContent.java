package com.grad.project.nc.service.notifications;

import com.grad.project.nc.model.Complain;


public class NewComplaintMailContent extends MailContent {
    public NewComplaintMailContent(Complain complain) {
        getContext().put("complaint", complain);
        getContext().put("user", complain.getUser());

        setSender("support@ncgrad.herokuapp.com");
        setSubject("Complaint created");

        setTemplateName("newComplaint.ftl");
    }
}
