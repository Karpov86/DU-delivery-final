package by.karpov.delivery.database.repository;

import by.karpov.delivery.database.entity.Category;
import by.karpov.delivery.database.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Long> {

    List<Dish> findAllByCategory(Category category);
}
