package com.anuanu00.expensesmanager.dto;

import com.anuanu00.expensesmanager.entities.Member;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class DueResponse {
    private Member memberWhoLent;
    private int amount;
}
