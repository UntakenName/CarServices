/*
 * Copyright (c) 2018 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.company.services.core;

import com.company.services.entity.Employee;
import com.haulmont.cuba.core.global.EmailException;
import com.haulmont.cuba.core.global.EmailInfo;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author gordeev
 */
public interface EmployeePostalService {

    List<EmailInfo> createEmails(List<Employee> employees, Map<UUID, String> congratulations);

    void sendEmails(List<EmailInfo> emails) throws EmailException;
}
