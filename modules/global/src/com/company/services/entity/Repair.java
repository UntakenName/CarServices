/*
 * Copyright (c) 2018 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */
package com.company.services.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.global.DeletePolicy;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.entity.annotation.OnDelete;

/**
 *
 * @author gordeev
 */
@NamePattern("%s %s|id,description")
@Table(name = "SERVICES_REPAIR")
@Entity(name = "services$Repair")
public class Repair extends StandardEntity {
    private static final long serialVersionUID = -1501946775381023950L;

    @Column(name = "DESCRIPTION")
    protected String description;

    @OnDelete(DeletePolicy.UNLINK)
    @OnDeleteInverse(DeletePolicy.CASCADE)
    @ManyToOne
    @JoinColumn(name = "CENTER_ID")
    protected CarServiceCenter center;

    @OnDelete(DeletePolicy.UNLINK)
    @OnDeleteInverse(DeletePolicy.UNLINK)
    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    protected Employee employee;

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setCenter(CarServiceCenter center) {
        this.center = center;
    }

    public CarServiceCenter getCenter() {
        return center;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }
}