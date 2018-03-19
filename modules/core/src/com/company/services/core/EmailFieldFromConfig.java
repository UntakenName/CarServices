/*
 * Copyright (c) 2018 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.company.services.core;

import com.haulmont.cuba.core.config.Config;
import com.haulmont.cuba.core.config.Property;
import com.haulmont.cuba.core.config.Source;
import com.haulmont.cuba.core.config.SourceType;
import com.haulmont.cuba.core.config.defaults.Default;

/**
 * @author gordeev
 */

@Source(type = SourceType.DATABASE)
public interface EmailFieldFromConfig extends Config{

    void setEmailFieldFrom();

    @Property("cuba.emailFiledFrom")
    @Default("DoNotReply@localhost")
    String getEmailFieldFrom();
}
