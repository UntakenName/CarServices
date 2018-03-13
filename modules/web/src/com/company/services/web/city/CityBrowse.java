/*
 * Copyright (c) 2018 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */
package com.company.services.web.city;

import com.company.services.entity.City;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.actions.CreateAction;
import com.haulmont.cuba.gui.components.actions.EditAction;
import com.haulmont.cuba.gui.data.GroupDatasource;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author gordeev
 */
public class CityBrowse extends AbstractLookup {

    @Inject
    private GroupDatasource<City, UUID> citiesDs;

    @Named("citiesTable.edit")
    private EditAction citiesTableEdit;

    @Named("citiesTable.create")
    private CreateAction citiesTableCreate;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
        citiesTableEdit.setAfterCommitHandler(new EditAction.AfterCommitHandler() {
            @Override
            public void handle(Entity entity) {
                citiesDs.refresh();
            }
        });
        citiesTableCreate.setAfterCommitHandler(new CreateAction.AfterCommitHandler() {
            @Override
            public void handle(Entity entity) {
                citiesDs.refresh();
            }
        });
    }
}