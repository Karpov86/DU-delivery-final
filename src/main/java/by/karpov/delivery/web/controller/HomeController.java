package by.karpov.delivery.web.controller;

import by.karpov.delivery.database.entity.Category;
import by.karpov.delivery.database.entity.Order;
import by.karpov.delivery.database.entity.User;
import by.karpov.delivery.service.DishService;
import by.karpov.delivery.service.OrderService;
import by.karpov.delivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class HomeController {

    private final UserService userService;
    private final DishService dishService;
    private final OrderService orderService;

    @Autowired
    public HomeController(UserService userService, DishService dishService, OrderService orderService) {
        this.userService = userService;
        this.dishService = dishService;
        this.orderService = orderService;
    }

    @ModelAttribute("currentUser")
    public User getCurrentUser() {
        return userService.getUserFromSecurityContext();
    }

    @ModelAttribute("currentOrder")
    public Order getCurrentOrder() {
        return orderService.getLastByUser(getCurrentUser());
    }

    @GetMapping
    public String homeView() {
        return "home";
    }

    @GetMapping("/menu")
    public String getDishes(
            @RequestParam(required = false) String category,
            Model model) {
        if (category == null || category.isEmpty()) {
            model.addAttribute("dishes", dishService.findAllByCategory(Category.PIZZA));
        } else {
            model.addAttribute("dishes", dishService.findAllByCategory(Category.valueOf(category.toUpperCase())));
        }
        return "menu";
    }


}
