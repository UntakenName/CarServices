/*
 * Copyright (c) 2018 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.company.services.core;

import com.company.services.entity.Employee;
import com.haulmont.cuba.core.app.EmailerAPI;
import com.haulmont.cuba.core.global.EmailException;
import com.haulmont.cuba.core.global.EmailInfo;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author gordeev
 */
@Component("services_EmployeePostalService")
public class EmployeePostalServiceImpl implements EmployeePostalService {

    @Inject
    private EmailerAPI emailerAPI;

    @Inject
    private EmailFieldFromConfig emailFieldFromConfig;

    @Inject
    private Logger log;

    @Override
    public List<EmailInfo> createEmails(List<Employee> employees, Map<UUID, String> congratulations) {
        EmailInfo email;
        String address;
        List<EmailInfo> emails = new ArrayList<EmailInfo>(employees.size());
        for (Employee employee : employees) {
            address = employee.getEmail();
            if (address != null) {
                email = new EmailInfo(address, "С Днём рождения!", congratulations.get(employee.getId()));
                email.setFrom(emailFieldFromConfig.getEmailFieldFrom());
                emails.add(email);
            }
        }
        return emails;
}

    @Override
    public void sendEmails(List<EmailInfo> emails) throws EmailException {
        for (EmailInfo email : emails){
            log.info("sending " + email.getBody());
            emailerAPI.sendEmail(email);
        }
    }
}