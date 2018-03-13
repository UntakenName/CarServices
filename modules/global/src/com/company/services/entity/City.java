/*
 * Copyright (c) 2018 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */
package com.company.services.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.Listeners;

/**
 *
 * @author gordeev
 */
@Listeners("services_DefaultCityEntityListener")
@NamePattern("%s|name")
@Table(name = "SERVICES_CITY")
@Entity(name = "services$City")
public class City extends StandardEntity {
    private static final long serialVersionUID = 775669117848227651L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @NotNull
    @Column(name = "CODE", nullable = false)
    protected String code;

    @Column(name = "DEFAULT_CITY")
    protected Boolean defaultCity;

    public void setDefaultCity(Boolean defaultCity) {
        this.defaultCity = defaultCity;
    }

    public Boolean getDefaultCity() {
        return defaultCity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}