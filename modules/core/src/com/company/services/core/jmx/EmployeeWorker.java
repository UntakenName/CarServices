/*
 * Copyright (c) 2018 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.company.services.core.jmx;

import com.company.services.core.EmployeeCongratulator;
import com.company.services.core.EmployeePostalService;
import com.company.services.entity.Employee;
import com.company.services.service.EmployeeService;
import com.haulmont.cuba.core.global.EmailInfo;
import com.haulmont.cuba.security.app.Authenticated;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.UUID;


/**
 * @author gordeev
 */
@Component("services_EmployeeWorkerMBean")
public class EmployeeWorker implements EmployeeWorkerMBean {

    @Inject
    private EmployeeService employeeService;

    @Inject
    private EmployeeCongratulator employeeCongratulator;

    @Inject
    private EmployeePostalService employeePostalService;

    @Override
    @Authenticated
    public String sendGreeting() {
        try {
            List<Employee> employees = employeeService.whoseBirthdayIsToday();
            Map<UUID, String> congratulations = employeeCongratulator.formCongratulations(employees);
            List<EmailInfo> emails = employeePostalService.createEmails(employees, congratulations);
            employeePostalService.sendEmails(emails);
            return "Done";
        } catch (Throwable e) {
            return ExceptionUtils.getStackTrace(e);
        }
    }
}