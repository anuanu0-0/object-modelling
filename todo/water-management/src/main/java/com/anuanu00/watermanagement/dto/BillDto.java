package com.anuanu00.watermanagement.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class BillDto {
    private final String id;
    private final int totalWaterConsumedInLts;
    private final int totalCost;

    public BillDto(String id, int totalWaterConsumedInLts, int totalCost) {
        this.id = id;
        this.totalWaterConsumedInLts = totalWaterConsumedInLts;
        this.totalCost = totalCost;
    }
}
