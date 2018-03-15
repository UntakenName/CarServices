/*
 * Copyright (c) 2018 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */
package com.company.services.listener;

import com.haulmont.cuba.core.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
import com.haulmont.cuba.core.EntityManager;
import com.company.services.entity.City;
import com.haulmont.cuba.core.listener.BeforeDetachEntityListener;
import com.haulmont.cuba.core.listener.BeforeUpdateEntityListener;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author gordeev
 */
@Component("services_DefaultCityEntityListener")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DefaultCityEntityListener implements BeforeInsertEntityListener<City>, BeforeUpdateEntityListener<City>, BeforeDetachEntityListener<City> {

    @Inject
    private DefaultCityEntityListener selfInjectionForTransactionalProxy;

    private static final String UPDATE = "update services$City c set c.defaultCity = false where c.defaultCity = true ";

    private static final String WHERE_ID_NOT = "and c.id <> :cityId";

    private static Map<String, Boolean> initialDefaultCityValues = new ConcurrentHashMap<>();

    @Override
    public void onBeforeInsert(City entity, EntityManager entityManager) {
        if (entity.getDefaultCity() == null) {
            entity.setDefaultCity(false);
        } else if (entity.getDefaultCity()) {
            selfInjectionForTransactionalProxy.updateDefaultCityValues(null, entityManager);
        }
    }

    @Override
    public void onBeforeUpdate(City entity, EntityManager entityManager) {
        Boolean initialDefaultCityValue = initialDefaultCityValues.remove(entity.getName());
        if (entity.getDefaultCity() && initialDefaultCityValue != null && !initialDefaultCityValue) {
            selfInjectionForTransactionalProxy.updateDefaultCityValues(entity.getId(), entityManager);
        }
    }

    @Override
    public void onBeforeDetach(City entity, EntityManager entityManager) {
        initialDefaultCityValues.putIfAbsent(entity.getName(),entity.getDefaultCity());
    }

    @Transactional
    private void updateDefaultCityValues(UUID cityId, EntityManager entityManager) {
        StringBuilder sql = new StringBuilder(UPDATE);
        boolean flagChangesInExistingCity = cityId != null;
        if (flagChangesInExistingCity) {
            sql.append(WHERE_ID_NOT);
        }
        Query query = entityManager.createQuery(sql.toString());
        if (flagChangesInExistingCity) {
            query.setParameter("cityId", cityId);
        }
        query.executeUpdate();
    }
}