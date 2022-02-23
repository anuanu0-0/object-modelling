package com.anuanu00.moviebooking.repository;

import com.anuanu00.moviebooking.entity.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

@DisplayName("CustomerRepositoryTest")
public class CustomerRepositoryTest {

    private CustomerRepository customerRepository;

    @BeforeEach
    public void setup() {
        Map<String, Customer> customerMap = new HashMap<>();
        customerMap.put("1", new Customer("1", "CustomerA", "test1@gmail.com"));
        customerMap.put("2", new Customer("2", "CustomerB", "test2@gmail.com"));
        customerMap.put("3", new Customer("3", "CustomerC", "test3@gmail.com"));
        customerRepository = new CustomerRepository(customerMap);
    }

    @Test
    @DisplayName("getCustomerById Should Return Customer Given Customer Id")
    public void getCinemaById_GivenCustomerId_ShouldReturnCustomer() {
        // Arrange
        Customer expectedCustomer = new Customer("3", "CustomerC", "test3@gmail.com");
        // Act
        Customer actualCustomer = customerRepository.getCustomerById("3");
        // Assert
        Assertions.assertEquals(expectedCustomer, actualCustomer);
    }

    @Test
    @DisplayName("getCustomerById Given Customer Id Should Return Null If Not Present")
    public void getCinemaById_GivenCustomerId_ShouldReturnNullIfNotPresent() {
        // Arrange
        String customerId = "4";
        // Act
        Customer actualCustomer = customerRepository.getCustomerById(customerId);
        // Assert
        Assertions.assertNull(actualCustomer);
    }

    @Test
    @DisplayName("saveCustomer method Should Save Customer")
    public void saveCustomer_ShouldSaveCustomer() {
        // Arrange
        Customer expectedCustomer = new Customer("4", "CustomerD", "test4@gmail.com");
        // Act
        customerRepository.saveCustomer(expectedCustomer);
        // Assert
        Assertions.assertEquals(expectedCustomer, customerRepository.getCustomerById("4"));
    }
}
