package com.anuanu00.expensesmanager.entities;


import lombok.Getter;

public class Due {
    private final Member memberWhoOwes;
    private final Member memberWhoLent;
    @Getter
    private int amount;

    public Due(Member memberWhoOwes, Member memberWhoLent, int amount) {
        this.memberWhoOwes = memberWhoOwes;
        this.memberWhoLent = memberWhoLent;
        this.amount = amount;
    }

    public String getMemberWhoOwesName() {
        return memberWhoOwes.getName();
    }

    public String getMemberWhoLentName() {
        return memberWhoLent.getName();
    }
}
