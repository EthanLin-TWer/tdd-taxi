package com.jiker.keju;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TaximeterPrinter {
    public static final String INPUT_LINE_PATTERN = "(\\d+)公里,等待(\\d+)分钟";

    private String getResultOutput(String input) {
        Pattern pattern = Pattern.compile(INPUT_LINE_PATTERN);
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

    public String process(String lines) {
        return Arrays
                .stream(lines.split("\n"))
                .map(this::getResultOutput)
                .collect(Collectors.joining("\n"));
    }
}
