/*
 * Copyright (c) 2018 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */
package com.company.services.web.carservicecenter;

import com.company.services.entity.Employee;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.services.entity.CarServiceCenter;
import com.haulmont.cuba.gui.components.Component;
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
    private CollectionDatasource<Employee, UUID> employeesDs;


}