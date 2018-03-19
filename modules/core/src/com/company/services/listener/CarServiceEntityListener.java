/*
 * Copyright (c) 2018 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */
package com.company.services.listener;

import com.haulmont.cuba.core.global.UserSessionSource;
import org.springframework.stereotype.Component;
import com.company.services.entity.CarServiceCenter;

import javax.inject.Inject;
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
import com.haulmont.cuba.core.EntityManager;

/**
 *
 * @author gordeev
 */
@Component("services_CarServiceEntityListener")
public class CarServiceEntityListener implements BeforeInsertEntityListener<CarServiceCenter> {

    @Inject
    private UserSessionSource userSessionSource;

    @Override
    public void onBeforeInsert(CarServiceCenter entity, EntityManager entityManager) {
        if (entity.getCreator() == null) {
            entity.setCreator(userSessionSource.getUserSession().getUser());
        }
    }
}