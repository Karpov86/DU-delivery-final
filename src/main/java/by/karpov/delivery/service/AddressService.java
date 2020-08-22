package by.karpov.delivery.service;

import by.karpov.delivery.database.entity.Address;

public interface AddressService {

    Address getById(Long id);

    Address save(Address address);

    void delete(Long id);

    void deleteByAddress(Address address);
}
