package by.karpov.delivery.service;

import by.karpov.delivery.database.entity.PersonalInfo;
import by.karpov.delivery.database.entity.User;

public interface PersonalInfoService {
    PersonalInfo getById(Long id);

    PersonalInfo save(PersonalInfo personalInfo);

    void delete(Long id);

    PersonalInfo getByUser(User user);
}
