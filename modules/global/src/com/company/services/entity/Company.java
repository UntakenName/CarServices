/*
 * Copyright (c) 2018 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */
package com.company.services.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.haulmont.chile.core.annotations.NamePattern;

/**
 *
 * @author gordeev
 */
@NamePattern("%s|name")
@PrimaryKeyJoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
@Table(name = "SERVICES_COMPANY")
@Entity(name = "services$Company")
@DiscriminatorValue("Company")
public class Company extends Customer {
    private static final long serialVersionUID = 8826684027194863955L;

    @NotNull
    @Column(name = "INN", nullable = false, length = 12)
    protected String inn;

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getInn() {
        return inn;
    }


}