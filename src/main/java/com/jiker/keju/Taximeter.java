package com.jiker.keju;

public class Taximeter {
    private final int mileage;
    private final int waitingMinutes;

    public static final int BASIC_PRICE = 6;

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
        final double waitingCharges = waitingMinutes * 0.25;

        return (int) Math.round(BASIC_PRICE + middleBand() + longDistanceFare() + waitingCharges);
    }

    private double longDistanceFare() {
        return (mileage > 8) ? (mileage - 8) * 0.4 : 0;
    }

    private double middleBand() {
        return mileage > 2 ? (mileage - 2) * 0.8 : 0;
    }
}
