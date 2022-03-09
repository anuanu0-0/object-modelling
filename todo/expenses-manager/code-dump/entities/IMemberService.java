package com.anuanu00.expensesmanager.services;

import com.anuanu00.expensesmanager.dto.DueResponse;

import java.util.List;

public interface IMemberService {
    List<DueResponse> getAllDues(String memberWhoOwes);
    void clearDues(String memberWhoOwes, String memberWhoLent, int amount);
    void spend(int amount, String spender, List<String> spentFor);
}
