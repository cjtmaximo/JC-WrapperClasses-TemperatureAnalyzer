package org.example;

import java.util.Scanner;

public class TemperatureAnalyzer {
    public static void main(String[] args) {
        // Part 1: Input and String Parsing
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Day 1 High Temperature (e.g., 28.5): ");
        String day1TempStr = scanner.nextLine();

        System.out.print("Enter Day 2 High Temperature (e.g., 28.5): ");
        String day2TempStr = scanner.nextLine();

        System.out.print("Enter Day 3 High Temperature (e.g., 28.5): ");
        String day3TempStr = scanner.nextLine();

        System.out.println();
        System.out.println("--- Temperature Analysis ---");
        System.out.println();

        double day1TempPrimitive = 0;
        try {
            day1TempPrimitive = Double.parseDouble(day1TempStr);
            System.out.println("Parsed Day 1 Temp (primitive double): " + day1TempPrimitive);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Exiting program.");
            System.exit(0);
        }

        double day2TempPrimitive = 0;
        try {
            day2TempPrimitive = Double.parseDouble(day2TempStr);
            System.out.println("Parsed Day 2 Temp (primitive double): " + day2TempPrimitive);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Exiting program.");
            System.exit(0);
        }

        // Part 2: Wrapper Object Creation (valueOf)
        Double day1TempWrapper = Double.valueOf(day1TempPrimitive);
        Double day2TempWrapper = Double.valueOf(day2TempPrimitive);

        // Part 3: Comparison (compareTo)
        System.out.println();
        int isDay1WarmerThanDay2 = day1TempWrapper.compareTo(day2TempWrapper);
        if (isDay1WarmerThanDay2 > 0) {
            System.out.println("Day 1 (" + day1TempWrapper + "°C) was warmer than Day 2 (" + day2TempWrapper + "°C).");
        } else if (isDay1WarmerThanDay2 == 0) {
            System.out.println("Day 1 (" + day1TempWrapper + "°C) has the same temperature as Day 2 (" + day2TempWrapper + "°C).");
        } else {
            System.out.println("Day 1 (" + day1TempWrapper + "°C) was cooler than Day 2 (" + day2TempWrapper + "°C).");
        }
        System.out.println();

        // Part 4: Primitive Extraction (xxxValue)
        float day1TempFloat = day1TempWrapper.floatValue();
        System.out.println("Extracted Day 1 Temp (primitive float from Double wrapper): " + day1TempFloat);
        int day2TempInt = day2TempWrapper.intValue();
        System.out.println("Extracted Day 2 Temp (primitive int from Double wrapper, truncated): " + day2TempInt);

        // Part 5: Extension (For the Third Temperature & Finding Max)
        System.out.println();
        double day3TempPrimitive = 0;
        try {
            day3TempPrimitive = Double.parseDouble(day3TempStr);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Exiting program.");
            System.exit(0);
        }

        Double day3TempWrapper = Double.valueOf(day3TempPrimitive);

        double day1TempWrapperToDouble = day1TempWrapper.doubleValue();
        double day2TempWrapperToDouble = day2TempWrapper.doubleValue();
        double day3TempWrapperToDouble = day3TempWrapper.doubleValue();

        double highestTemp = Math.max(day1TempWrapperToDouble, day2TempWrapperToDouble);
        highestTemp = Math.max(highestTemp, day3TempWrapperToDouble);

        System.out.println("The highest temperature recorded was: " + highestTemp + "°C");
    }
}
