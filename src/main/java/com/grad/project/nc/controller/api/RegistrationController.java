package com.grad.project.nc.controller.api;

import com.grad.project.nc.controller.api.data.RegistrationResponseHolder;
import com.grad.project.nc.model.User;
import com.grad.project.nc.service.exceptions.IncorrectUserDataException;
import com.grad.project.nc.service.notifications.EmailService;
import com.grad.project.nc.service.security.AutoLoginService;
import com.grad.project.nc.service.security.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private AutoLoginService autoLoginService;

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public RegistrationResponseHolder registration(@RequestBody User user) {

        RegistrationResponseHolder registrationResponse = new RegistrationResponseHolder();

        try {
            registrationService.validation(user);
            registrationService.register(user);
            registrationResponse.setMessage("You've been registered successfully");
            emailService.sendRegistrationEmail(user);
            autoLoginService.autologin(user.getEmail(), user.getPassword());
        } catch (IncorrectUserDataException e) {
            registrationResponse.setMessage(e.getMessage());
        }
        registrationResponse.setStatus(registrationService.getStatus());

        return registrationResponse;
    }
}
