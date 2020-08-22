package by.karpov.delivery.web.controller;

import by.karpov.delivery.database.entity.CreditCard;
import by.karpov.delivery.database.entity.Order;
import by.karpov.delivery.database.entity.PersonalInfo;
import by.karpov.delivery.database.entity.User;
import by.karpov.delivery.service.CreditCardService;
import by.karpov.delivery.service.OrderService;
import by.karpov.delivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/creditCard")
public class CreditCardController {

    private final UserService userService;
    private final CreditCardService creditCardService;
    private final OrderService orderService;

    @Autowired
    public CreditCardController(UserService userService, CreditCardService creditCardService, OrderService orderService) {
        this.userService = userService;
        this.creditCardService = creditCardService;
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

    @ModelAttribute("newCreditCard")
    public CreditCard getNewCreditCard() {
        return new CreditCard();
    }

    @GetMapping("/add")
    public String addCreditCard() {
        return "creditCardAdd";
    }

    @PostMapping("/add")
    public String addCreditCard(CreditCard newCreditCard) {
        PersonalInfo personalInfo = getCurrentUser().getPersonalInfo();
        newCreditCard.setPersonalInfo(personalInfo);
        creditCardService.save(newCreditCard);
        return "redirect:/user/" + getCurrentUser().getId();
    }

    @PostMapping("/delete")
    public String deleteCreditCard(@RequestParam Long id) {
        creditCardService.delete(id);
        return "redirect:/user/" + getCurrentUser().getId();
    }
}

