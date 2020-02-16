package com.jiker.keju;

public class Taximeter {
    public static final int FREE_KILOMETERS = 2;
    public static final int LONG_DISTANCE_BASE_KILOMETERS = 8;
    public static final int CHARGES_BASIC_PRICE = 6;
    public static final double CHARGES_PER_KILOMETER = 0.8;
    public static final double CHARGES_PER_MINUTE_WAITING = 0.25;
    public static final double CHARGES_PERCENT_OF_LONG_DISTANCE_KILOMETERS = 0.5;

    private final int mileage;
    private final int waitingMinutes;

    public Taximeter(int mileage, int waitingMinutes) {
        this.mileage = mileage;
        this.waitingMinutes = waitingMinutes;
    }

    public Taximeter(int mileage) {
        this(mileage, 0);
    }

    public static String process(String input) {
        return "收费6元";
    }

    public int calculatePrice() {
        return (int) Math.round(CHARGES_BASIC_PRICE + mileageCharges() + longDistanceFare() + waitingCharges());
    }

    private double waitingCharges() {
        return waitingMinutes * CHARGES_PER_MINUTE_WAITING;
    }

    private double longDistanceFare() {
        if (mileage > LONG_DISTANCE_BASE_KILOMETERS) {
            return (mileage - LONG_DISTANCE_BASE_KILOMETERS) * CHARGES_PER_KILOMETER * CHARGES_PERCENT_OF_LONG_DISTANCE_KILOMETERS;
        }

        return 0;
    }

    private double mileageCharges() {
        if (mileage > FREE_KILOMETERS) {
            return (mileage - FREE_KILOMETERS) * CHARGES_PER_KILOMETER;
        }

        return 0;
    }
}
