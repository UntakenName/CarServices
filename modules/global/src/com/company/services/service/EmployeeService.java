/*
 * Copyright (c) 2018 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */
package com.company.services.service;

import com.company.services.entity.Employee;

import java.util.List;

/**
 *
 * @author gordeev
 */
public interface EmployeeService {
    String NAME = "services_EmployeeService";

    List<Employee> whoseBirthdayIsToday();
}