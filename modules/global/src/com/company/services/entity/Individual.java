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
@PrimaryKeyJoinColumn(name = "INDIVIDUAL_ID", referencedColumnName = "ID")
@Table(name = "SERVICES_INDIVIDUAL")
@NamePattern("%s|name")
@Entity(name = "services$Individual")
@DiscriminatorValue("Individual")
public class Individual extends Customer {
    private static final long serialVersionUID = 2781230436607610600L;

    @NotNull
    @Column(name = "PASSPORT_NO", nullable = false, length = 10)
    protected String passportNo;

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getPassportNo() {
        return passportNo;
    }


}