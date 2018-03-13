/*
 * Copyright (c) 2018 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */
package com.company.services.web.city;

import com.company.services.service.CityService;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.services.entity.City;

import javax.inject.Inject;

/**
 *
 * @author gordeev
 */
public class CityEdit extends AbstractEditor<City> {

    @Inject
    private CityService cityService;

    Boolean initialDefaultStatus;

    @Override
    protected void postInit() {
        super.postInit();
        initialDefaultStatus = getItem().getDefaultCity();
    }

    @Override
    protected boolean postCommit(boolean committed, boolean close) {
        City item = getItem();
        if (committed && item.getDefaultCity() && ! item.getDefaultCity().equals(initialDefaultStatus)) {
            cityService.resetDefaultCity(item.getId());
        }
        return super.postCommit(committed, close);
    }
}