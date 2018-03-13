/*
 * Copyright (c) 2018 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */
package com.company.services.service;

import com.company.services.entity.City;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.TypedQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 *
 * @author gordeev
 */
@Service(CityService.NAME)
public class CityServiceBean implements CityService {

    @Inject
    private Persistence persistence;

    private static final String SELECT_DEFAULT_CITY = "select c from services$City c where c.defaultCity = true";

    @Transactional
    @Override
    public City getDefaultCity() {
        TypedQuery<City> query = persistence.getEntityManager().createQuery(SELECT_DEFAULT_CITY, City.class);
        return query.getFirstResult();
    }
}