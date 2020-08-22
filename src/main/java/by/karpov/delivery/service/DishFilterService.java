package by.karpov.delivery.service;

import by.karpov.delivery.database.entity.Dish;
import by.karpov.delivery.database.repository.DishFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishFilterService {

    private final DishFilter dishFilter;

    @Autowired
    public DishFilterService(DishFilter dishFilter) {
        this.dishFilter = dishFilter;
    }

    public List<Dish> filter(Dish dish) {
        return dishFilter.filter(dish);
    }
}
