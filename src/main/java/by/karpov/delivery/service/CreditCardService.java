package by.karpov.delivery.service;

import by.karpov.delivery.database.entity.CreditCard;

public interface CreditCardService {

    CreditCard getById(Long id);

    CreditCard save(CreditCard creditCard);

    void delete(Long id);

    void deleteByCreditCard(CreditCard creditCard);
}
