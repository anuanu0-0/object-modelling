package com.anuanu00.expensesmanager.services;

import com.anuanu00.expensesmanager.dto.DueResponse;
import com.anuanu00.expensesmanager.repositories.IMemberRepository;

import java.util.List;

public class MemberService implements IMemberService{

    private final IMemberRepository iMemberRepository;

    public MemberService(IMemberRepository iMemberRepository) {
        this.iMemberRepository = iMemberRepository;
    }

    @Override
    public List<DueResponse> getAllDues(String memberWhoOwes) {
        return null;
    }

    @Override
    public void clearDues(String memberWhoOwes, String memberWhoLent, int amount) {

    }

    @Override
    public void spend(int amount, String spender, List<String> spentFor) {

    }
}
