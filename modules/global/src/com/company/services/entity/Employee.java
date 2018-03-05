/*
 * Copyright (c) 2018 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */
package com.company.services.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author gordeev
 */
@NamePattern("%s %s|firstName,lastName")
@Table(name = "SERVICES_EMPLOYEE")
@Entity(name = "services$Employee")
public class Employee extends StandardEntity {
    private static final long serialVersionUID = 5294644609214426199L;

    @NotNull
    @Column(name = "FIRST_NAME", nullable = false)
    protected String firstName;

    @NotNull
    @Column(name = "LAST_NAME", nullable = false)
    protected String lastName;

    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name = "BIRTH_DATE", nullable = false)
    protected Date birthDate;

    @Column(name = "EMAIL", length = 100)
    protected String email;

    @NotNull
    @Column(name = "SALARY", nullable = false, precision = 10, scale = 2)
    protected BigDecimal salary;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CENTER_ID")
    protected CarServiceCenter center;

    public void setCenter(CarServiceCenter center) {
        this.center = center;
    }

    public CarServiceCenter getCenter() {
        return center;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getSalary() {
        return salary;
    }


}