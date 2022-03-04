package com.anuanu00.watermanagement.entities.waterProviders;

import com.anuanu00.watermanagement.entities.WaterProvider;

public class BorewellWater implements WaterProvider {

    private static final float waterRate = 1.5f;

    @Override
    public Number getWaterCost() {
        return waterRate;
    }
}
