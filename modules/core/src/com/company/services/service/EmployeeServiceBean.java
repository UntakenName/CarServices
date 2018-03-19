/*
 * Copyright (c) 2018 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */
package com.company.services.service;

import com.company.services.entity.Employee;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.TypedQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author gordeev
 */
@Service(EmployeeService.NAME)
public class EmployeeServiceBean implements EmployeeService {

    private static final String SELECT_EMPLOYEES = "select * from services_employee " +
            "where date_part('day', birth_date) = #day and date_part('month', birth_date) = #month and delete_ts is null";
    @Inject
    private Persistence persistence;

    private Calendar calendar = Calendar.getInstance();

    @Transactional
    @Override
    public List<Employee> whoseBirthdayIsToday(){
        TypedQuery<Employee> query = persistence.getEntityManager().createNativeQuery(SELECT_EMPLOYEES , Employee.class);
        query.setParameter("day", calendar.get(Calendar.DAY_OF_MONTH));
        query.setParameter("month", calendar.get(Calendar.MONTH) + 1);
        return query.getResultList();
    }
}