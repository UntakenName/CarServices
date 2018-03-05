/*
 * Copyright (c) 2018 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */
package com.company.services.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.haulmont.chile.core.annotations.NamePattern;

/**
 *
 * @author gordeev
 */
@NamePattern("%s %s|customer,carServiceCenter")
@Table(name = "SERVICES_CUSTOMER_SERVICE")
@Entity(name = "services$CustomerService")
public class CustomerService extends StandardEntity {
    private static final long serialVersionUID = -5724123355252983270L;

    @NotNull
    @OnDelete(DeletePolicy.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CUSTOMER_ID")
    protected Customer customer;

    @NotNull
    @OnDelete(DeletePolicy.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CAR_SERVICE_CENTER_ID")
    protected CarServiceCenter carServiceCenter;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCarServiceCenter(CarServiceCenter carServiceCenter) {
        this.carServiceCenter = carServiceCenter;
    }

    public CarServiceCenter getCarServiceCenter() {
        return carServiceCenter;
    }


}