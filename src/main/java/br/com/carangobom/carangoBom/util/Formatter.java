package br.com.carangobom.carangoBom.util;

public class Formatter {

    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}
