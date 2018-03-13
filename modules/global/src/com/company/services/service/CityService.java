/*
 * Copyright (c) 2018 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */
package com.company.services.service;

import com.company.services.entity.City;

import java.util.UUID;

/**
 *
 * @author gordeev
 */
public interface CityService {
    String NAME = "services_CityService";

    City getDefaultCity();

    void resetDefaultCity(UUID cityId);
}