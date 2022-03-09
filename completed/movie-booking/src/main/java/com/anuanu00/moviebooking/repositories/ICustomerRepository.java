package com.anuanu00.moviebooking.repositories;

import com.anuanu00.moviebooking.entites.Customer;

public interface ICustomerRepository {
    Customer getCustomerById(String id);
    void saveCustomer(Customer customer);
}
