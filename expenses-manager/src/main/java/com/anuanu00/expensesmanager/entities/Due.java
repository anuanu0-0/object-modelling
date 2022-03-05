package com.anuanu00.expensesmanager.entities;

public class Due {
    private final Member memberWhoOwes;
    private final Member memberWhoLent;
    private int amount;

    public Due(Member memberWhoOwes, Member memberWhoLent, int amount) {
        this.memberWhoOwes = memberWhoOwes;
        this.memberWhoLent = memberWhoLent;
        this.amount = amount;
    }
}
