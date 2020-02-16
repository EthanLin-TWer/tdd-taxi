package com.jiker.keju;

public class Taximeter {
    private int mileage;
    private int waitingMinutes;

    public Taximeter(int mileage, int waitingMinutes) {
        this.mileage = mileage;
        this.waitingMinutes = waitingMinutes;
    }

    public Taximeter(int mileage) {
        this(mileage, 0);
    }

    public static String process(String input) {
        return null;
    }

    public int calculatePrice() {
        final int basicPrice = 6;
        final double waitingCharges = waitingMinutes * 0.25;

        if (mileage > 8) {
            return (int) Math.round(basicPrice + 6 * 0.8 + (11 - 6 - 2) * 0.8 * 1.5 + waitingCharges);
        }

        if (mileage > 2) {
            return (int) Math.round(basicPrice + (mileage - 2) * 0.8 + waitingCharges);
        }

        return (int) Math.round(basicPrice + waitingCharges);
    }
}
