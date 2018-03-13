/*
 * Copyright (c) 2018 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */
package com.company.services.web.carservicecenter;

import com.company.services.service.CityService;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.services.entity.CarServiceCenter;

import javax.inject.Inject;

/**
 *
 * @author gordeev
 */
public class CarServiceCenterEdit extends AbstractEditor<CarServiceCenter> {

    @Inject
    private CityService cityService;

    @Override
    protected void initNewItem(CarServiceCenter item) {
        super.initNewItem(item);
        item.setCity(cityService.getDefaultCity());
    }
}