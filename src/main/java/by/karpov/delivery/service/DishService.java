package by.karpov.delivery.service;

import by.karpov.delivery.database.entity.Category;
import by.karpov.delivery.database.entity.Dish;

import java.util.List;

public interface DishService {

    Dish getById(Long id);

    List<Dish> findAll();

    Dish save(Dish dish);

    Dish update(Dish dish);

    void delete(Long id);

    List<Dish> findAllByCategory(Category category);
}
