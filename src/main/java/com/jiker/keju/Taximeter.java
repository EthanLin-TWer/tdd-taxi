package com.jiker.keju;

public class Taximeter {
    public static final double CHARGES_PER_MINUTE_WAITING = 0.25;
    public static final int LONG_DISTANCE_BASE = 8;
    public static final int FREE_KILOMETERS = 2;
    public static final double CHARGES_PER_KILOMETER = 0.8;
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
        return (int) Math.round(BASIC_PRICE + mileageCharges() + longDistanceFare() + waitingCharges());
    }

    private double waitingCharges() {
        return waitingMinutes * CHARGES_PER_MINUTE_WAITING;
    }

    private double longDistanceFare() {
        return (mileage > LONG_DISTANCE_BASE) ? (mileage - LONG_DISTANCE_BASE) * CHARGES_PER_KILOMETER * 0.5 : 0;
    }

    private double mileageCharges() {
        return mileage > FREE_KILOMETERS ? (mileage - FREE_KILOMETERS) * CHARGES_PER_KILOMETER : 0;
    }
}
