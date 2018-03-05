package com.company.services.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorType;
import javax.persistence.Inheritance;
import javax.persistence.DiscriminatorColumn;
import com.haulmont.cuba.core.entity.StandardEntity;

@DiscriminatorColumn(name = "CUSTOMER_TYPE", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.JOINED)
@NamePattern("%s|name")
@Table(name = "SERVICES_CUSTOMER")
@Entity(name = "services$Customer")
public abstract class Customer extends StandardEntity {
    private static final long serialVersionUID = 5639861158477172084L;

    @NotNull
    @Column(name = "NAME", nullable = false, length = 200)
    protected String name;

    @Column(name = "PHONE", length = 10)
    protected String phone;

    @Column(name = "EMAIL", length = 50)
    protected String email;



    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }


}