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
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.TabSheet;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import javax.inject.Inject;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author gordeev
 */
public class CarServiceCenterEdit extends AbstractEditor<CarServiceCenter> {

    private enum CustomerType {
        INDIVIDUAL,
        COMPANY
    }

    @Inject
    private CityService cityService;

    @Inject
    private CollectionDatasource<Customer, UUID> customersDs;

    @Inject
    private TabSheet services_tab_sheet;

    @Inject
    private Table<Customer> customers_table;

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
        customers_table.addGeneratedColumn("type", new Table.ColumnGenerator<Customer>() {
            @Override
            public Component generateCell(Customer entity) {
                String customerTypeLiteral = entity.getClass().toString();
                customerTypeLiteral = customerTypeLiteral.substring(customerTypeLiteral.lastIndexOf('.') + 1);
                CustomerType customerType = CustomerType.valueOf(customerTypeLiteral.toUpperCase());
                return new Table.PlainTextCell(messages.getMessage(customerType));
            }
        });
        String caption = messages.getMessage("com.company.services.web.carservicecenter","Type");
        customers_table.getColumn("type").setCaption(caption);
    }
}