package by.karpov.delivery.service;

import by.karpov.delivery.database.entity.Order;
import by.karpov.delivery.database.entity.User;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {
    Order getById(Long id);

    Order save(Order order);

    void delete(Long id);

    BigDecimal getTotalPrice(Order order);

    List<Order> getAllByUser(User user);

    Order getLastByUser(User user);

}
