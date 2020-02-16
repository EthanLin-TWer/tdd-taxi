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

        if (mileage > 2) {
            return (int) Math.round(basicPrice + (mileage - 2) * 0.8);
        }

        return basicPrice;
    }
}
