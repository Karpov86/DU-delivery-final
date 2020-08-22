package by.karpov.delivery.database.repository;

import by.karpov.delivery.database.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
