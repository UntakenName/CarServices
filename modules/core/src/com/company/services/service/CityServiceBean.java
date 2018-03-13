/*
 * Copyright (c) 2018 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */
package com.company.services.service;

import com.company.services.entity.City;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Query;
import com.haulmont.cuba.core.TypedQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.UUID;

/**
 *
 * @author gordeev
 */
@Service(CityService.NAME)
public class CityServiceBean implements CityService {

    @Inject
    private Persistence persistence;

    @Transactional
    @Override
    public City getDefaultCity() {
        TypedQuery<City> query = persistence.getEntityManager().createQuery(
                "select c from services$City c where c.defaultCity = true", City.class);
        return query.getFirstResult();
    }

    @Transactional
    @Override
    public void resetDefaultCity(UUID cityId) {
        Query query = persistence.getEntityManager().createQuery(
                "update services$City c set c.defaultCity = false where c.id <> :cityId"
        );
        query.setParameter("cityId",cityId);
        query.executeUpdate();
    }
}