/*
 * Copyright (c) 2018 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

import com.company.services.entity.Employee

/**
 *
 * @author gordeev
 */

List<Employee> employees = employees

Date today = today

Map<UUID, String> result = new HashMap<UUID, String>(employees.size())

String congratulation

Integer age

for (Employee employee : employees) {
    age = today.year - employee.birthDate.year
    congratulation = formCongratulation(employee.firstName, employee.lastName, age, employee.center.name)
    result.put(employee.id, congratulation)
}

return result

String formCongratulation(String firstName, String lastName, Integer age, String centerName) {
    String form = "Поздравляем вас с днем рождения, ${firstName} ${lastName}!\n" +
                    "Желаем всего наилучшего в ваши  ${age}!\n" +
                    "С уважением, коллектив автосервиса \"${centerName}\"."
    return form
}