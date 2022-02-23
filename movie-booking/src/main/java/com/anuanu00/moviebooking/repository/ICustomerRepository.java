package com.anuanu00.moviebooking.repository;

import com.anuanu00.moviebooking.entity.Customer;

public interface ICustomerRepository {
    Customer getCustomerById(String id);
    void saveCustomer(Customer customer);
}
