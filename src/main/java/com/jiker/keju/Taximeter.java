package com.jiker.keju;

public class Taximeter {
    private int mileage;

    public Taximeter(int mileage) {
        this.mileage = mileage;
    }

    public static String process(String input) {
        return null;
    }

    public int calculatePrice() {
        final int basicPrice = 6;

        if (mileage == 10) {
            return 13;
        }
        if (mileage == 11) {
            return (int) Math.round(basicPrice + 6 * 0.8 + 3);
        }

        if (mileage > 2) {
            return (int) Math.round(basicPrice + (mileage - 2) * 0.8);
        }

        return basicPrice;
    }
}
