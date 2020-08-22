package by.karpov.delivery.service.impl;

import by.karpov.delivery.database.entity.Category;
import by.karpov.delivery.database.entity.Dish;
import by.karpov.delivery.database.repository.DishRepository;
import by.karpov.delivery.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;

    @Autowired
    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public Dish getById(Long id) {
        return dishRepository.getOne(id);
    }

    @Override
    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    @Override
    public Dish save(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public Dish update(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public void delete(Long id) {
        dishRepository.deleteById(id);
    }

    @Override
    public List<Dish> findAllByCategory(Category category) {
        return dishRepository.findAllByCategory(category);
    }
}
