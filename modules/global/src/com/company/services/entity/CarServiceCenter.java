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
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Set;
import javax.persistence.OneToMany;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author gordeev
 */
@NamePattern("%s %s|name,address")
@Table(name = "SERVICES_CAR_SERVICE_CENTER")
@Entity(name = "services$CarServiceCenter")
public class CarServiceCenter extends StandardEntity {
    private static final long serialVersionUID = -8287078032562728640L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @Column(name = "PHONE", length = 10)
    protected String phone;

    @Lookup(type = LookupType.SCREEN, actions = {"lookup", "open"})
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @NotNull
    @OnDelete(DeletePolicy.CASCADE)
    @JoinColumn(name = "CITY_ID")
    protected City city;

    @NotNull
    @Column(name = "ADDRESS", nullable = false)
    protected String address;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "center")
    protected Set<Employee> employees;


    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "center")
    protected Set<Repair> repairs;

    @JoinTable(name = "SERVICES_CUSTOMER_SERVICE",
        joinColumns = @JoinColumn(name = "CENTER_ID"),
        inverseJoinColumns = @JoinColumn(name = "CUSTOMER_ID"))
    @ManyToMany
    @OnDelete(DeletePolicy.UNLINK)
    protected Set<Customer> customers;

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }



    public void setRepairs(Set<Repair> repairs) {
        this.repairs = repairs;
    }

    public Set<Repair> getRepairs() {
        return repairs;
    }


    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}