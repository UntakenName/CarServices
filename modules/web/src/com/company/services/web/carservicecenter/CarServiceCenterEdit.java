/*
 * Copyright (c) 2018 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */
package com.company.services.web.carservicecenter;

import com.company.services.entity.Customer;
import com.company.services.service.CityService;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.services.entity.CarServiceCenter;
import com.haulmont.cuba.gui.components.TabSheet;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import javax.inject.Inject;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author gordeev
 */
public class CarServiceCenterEdit extends AbstractEditor<CarServiceCenter> {

    @Inject
    private CityService cityService;

    @Inject
    private CollectionDatasource<Customer, UUID> customersDs;

    @Inject
    private TabSheet services_tab_sheet;

    @Override
    protected void initNewItem(CarServiceCenter item) {
        super.initNewItem(item);
        item.setCity(cityService.getDefaultCity());
    }

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
        customersDs.addCollectionChangeListener(new CollectionDatasource.CollectionChangeListener<Customer, UUID>() {

            @Override
            public void collectionChanged(CollectionDatasource.CollectionChangeEvent<Customer, UUID> e) {
                Integer customerAmount = e.getDs().getItems().size();
                services_tab_sheet.getTab("customers_tab")
                        .setCaption("Customers (" + customerAmount.toString() + ")");
            }
        });
    }
}