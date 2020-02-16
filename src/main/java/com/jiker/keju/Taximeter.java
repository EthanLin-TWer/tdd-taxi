package com.jiker.keju;

public class Taximeter {
    private int mileage;

    public Taximeter(int mileage) {
        this.mileage = mileage;
    }

    public static String process(String input) {
        return null;
    }

    public double calculatePrice() {
        if (mileage > 2) {
            return 6.8;
        }
        return 6.0;
    }
}
