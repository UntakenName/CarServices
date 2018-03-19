/*
 * Copyright (c) 2018 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.company.services.core.jmx;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

/**
 * @author gordeev
 */
@ManagedResource(description = "Congratulates the employees.")
public interface EmployeeWorkerMBean {

    @ManagedOperation(description = "Sends congratulations to all whose BD is today.")
    String sendGreeting();
}
