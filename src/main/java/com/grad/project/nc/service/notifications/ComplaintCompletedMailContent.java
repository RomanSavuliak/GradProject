package com.grad.project.nc.service.notifications;

import com.grad.project.nc.model.Complain;


public class ComplaintCompletedMailContent extends MailContent {
    public ComplaintCompletedMailContent(Complain complain) {
        getContext().put("complaint", complain);
        getContext().put("user", complain.getUser());

        setSender("support@ncgrad.herokuapp.com");
        setSubject("Complaint complete!");

        setTemplateName("complaintComplete.ftl");
    }
}
