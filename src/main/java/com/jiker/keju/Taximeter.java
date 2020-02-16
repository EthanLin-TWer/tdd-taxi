package com.jiker.keju;

import sun.rmi.runtime.Log;

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

        return (int) Math.round(basicPrice + middleBand() + longDistanceFare() + waitingCharges);
    }

    private double longDistanceFare() {
        return (mileage > 8) ? (mileage - 8) * 0.4 : 0;
    }

    private double middleBand() {
        return mileage > 2 ? (mileage - 2) * 0.8 : 0;
    }
}
