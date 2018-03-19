/*
 * Copyright (c) 2018 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.company.services.core;

import com.company.services.entity.Employee;
import com.haulmont.cuba.core.global.Scripting;
import com.haulmont.cuba.core.global.TimeSource;
import groovy.lang.Binding;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author gordeev
 *
 */
@Component("services_EmployeeCongratulator")
public class EmployeeCongratulatorImpl implements EmployeeCongratulator {

    @Inject
    private Scripting scripting;

    @Inject
    private TimeSource timeSource;

    @Override
    public Map<UUID, String> formCongratulations(List<Employee> employees) {
        Binding binding = new Binding();
        binding.setVariable("employees", employees);
        binding.setVariable("today", timeSource.currentTimestamp());
        return scripting.runGroovyScript("FormBirthDayCongratulaion.groovy", binding);
    }
}
