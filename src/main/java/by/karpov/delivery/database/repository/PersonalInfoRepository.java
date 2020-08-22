package by.karpov.delivery.database.repository;

import by.karpov.delivery.database.entity.PersonalInfo;
import by.karpov.delivery.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, Long> {

    PersonalInfo findByUser(User user);
}
