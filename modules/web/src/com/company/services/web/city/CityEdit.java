/*
 * Copyright (c) 2018 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */
package com.company.services.web.city;

import com.haulmont.cuba.core.app.DataService;
import com.haulmont.cuba.core.global.CommitContext;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.services.entity.City;

import javax.inject.Inject;
import java.util.List;

/**
 *
 * @author gordeev
 */
public class CityEdit extends AbstractEditor<City> {

    @Inject
    private DataService dataService;

    Boolean initialDefaultStatus;

    @Override
    protected void postInit() {
        super.postInit();
        initialDefaultStatus = getItem().getDefaultCity();
    }

    @Override
    protected boolean postCommit(boolean committed, boolean close) {
        City item = getItem();
        if (committed && item.getDefaultCity() && !item.getDefaultCity().equals(initialDefaultStatus)) {
            LoadContext<City> context = LoadContext.create(City.class).setQuery(
                    LoadContext.createQuery("select c from services$City c where c.id <> :itemId and c.defaultCity = true")
                            .setParameter("itemId", item.getId())
            );
            List<City> list = dataService.loadList(context);
            for (City city : list) {
                city.setDefaultCity(false);
            }
            dataService.commit(new CommitContext(list));
        }
        return super.postCommit(committed, close);
    }
}