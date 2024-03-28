package com.example.llab03;

public class UnitConverter {
    public double convert(double value, String fromUnit, String toUnit) {
        switch (fromUnit) {
            case "mm":
                return convertToMillimeters(value, toUnit);
            case "cm":
                return convertToCentimeters(value, toUnit);
            case "m":
                return convertToMeters(value, toUnit);
            case "km":
                return convertToKilometers(value, toUnit);
            default:
                throw new IllegalArgumentException("Unsupported unit: " + fromUnit);
        }
    }

    private double convertToMillimeters(double value, String toUnit) {
        switch (toUnit) {
            case "mm":
                return value;
            case "cm":
                return value / 10.0;
            case "m":
                return value / 1000.0;
            case "km":
                return value / 1000000.0;
            default:
                return 0.0; // Обработка некорректных значений
        }
    }

    private double convertToCentimeters(double value, String toUnit) {
        switch (toUnit) {
            case "mm":
                return value * 10.0;
            case "cm":
                return value;
            case "m":
                return value / 100.0;
            case "km":
                return value / 100000.0;
            default:
                return 0.0; // Обработка некорректных значений
        }
    }

    private double convertToMeters(double value, String toUnit) {
        switch (toUnit) {
            case "mm":
                return value * 1000.0;
            case "cm":
                return value * 100.0;
            case "m":
                return value;
            case "km":
                return value / 1000.0;
            default:
                return 0.0; // Обработка некорректных значений
        }
    }

    private double convertToKilometers(double value, String toUnit) {
        switch (toUnit) {
            case "mm":
                return value * 1000000.0;
            case "cm":
                return value * 100000.0;
            case "m":
                return value * 1000.0;
            case "km":
                return value;
            default:
                return 0.0; // Обработка некорректных значений
        }
    }
}

