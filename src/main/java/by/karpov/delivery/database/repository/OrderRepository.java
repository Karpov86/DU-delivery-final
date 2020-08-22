package by.karpov.delivery.database.repository;

import by.karpov.delivery.database.entity.Order;
import by.karpov.delivery.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByUser(User user);
}
