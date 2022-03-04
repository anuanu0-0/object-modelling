package com.anuanu00.watermanagement.entities.waterProviders;

import com.anuanu00.watermanagement.entities.WaterProvider;

public class CorporationWater implements WaterProvider {

    private static final int waterRate = 1;

    @Override
    public Number getWaterCost() {
        return waterRate;
    }
}
