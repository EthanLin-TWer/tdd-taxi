package com.jiker.keju;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Pattern pattern = Pattern.compile("(\\d+)公里,等待(\\d+)分钟");
        Matcher result = pattern.matcher(input);
        if (result.find()) {
            final int mileage = Integer.parseInt(result.group(1));
            final int waitingMinutes = Integer.parseInt(result.group(2));
            int price = new Taximeter(mileage, waitingMinutes).calculatePrice();
            return "收费" + price + "元";
        }
        // todo: input file format error
        // not implemented since the problem itself does not state this case
        return null;
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
