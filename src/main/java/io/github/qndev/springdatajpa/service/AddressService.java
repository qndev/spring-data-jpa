package io.github.qndev.springdatajpa.service;

import io.github.qndev.springdatajpa.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void deleteAddressByUserId(String userId) {
        addressRepository.deleteAddressByUserIdUsingQuery(userId);
    }

}
