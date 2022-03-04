package com.anuanu00.watermanagement.entities.waterProviders;

import com.anuanu00.watermanagement.entities.WaterProvider;

public class TankerWater implements WaterProvider {

    // Helper method
    public int getRates(int waterInLitres) {
        if (waterInLitres <= 500) {
            return 2;
        } else if (waterInLitres >= 501 && waterInLitres <= 1500) {
            return 3;
        } else if (waterInLitres >= 1501 && waterInLitres <= 3000) {
            return 5;
        } else {
            return 8;
        }
    }

    @Override
    public Number getWaterCost() {

        return 0;
    }
}
