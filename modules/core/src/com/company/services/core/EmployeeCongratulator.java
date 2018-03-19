/*
 * Copyright (c) 2018 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.company.services.core;

import com.company.services.entity.Employee;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author gordeev
 */
public interface EmployeeCongratulator {

    Map<UUID, String> formCongratulations(List<Employee> employees);
}
