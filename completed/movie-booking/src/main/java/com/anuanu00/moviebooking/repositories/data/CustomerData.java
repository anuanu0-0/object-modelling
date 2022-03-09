package com.anuanu00.moviebooking.repositories.data;

import com.anuanu00.moviebooking.entites.Customer;
import com.anuanu00.moviebooking.repositories.ICustomerRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.List;

public class CustomerData implements IData {

    private final ICustomerRepository iCustomerRepository;

    public CustomerData(ICustomerRepository iCustomerRepository) {
        this.iCustomerRepository = iCustomerRepository;
    }

    @Override
    public void loadData(String dataPath, String delimiter) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(dataPath));
            String line = bufferedReader.readLine();
            while (line != null) {
                List<String> tokens = Arrays.asList(line.split(delimiter));
                addCustomer(tokens.get(0), tokens.get(1), tokens.get(2));
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addCustomer(String customerId, String name, String email) {
        this.iCustomerRepository.saveCustomer(new Customer(customerId, name, email));
    }
}
