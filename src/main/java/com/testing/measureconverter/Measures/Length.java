package com.testing.measureconverter.Measures;

public class Length {
    private double number;
    private String measure;

    public Length(double number, String measure) {
        this.number = number;
        this.measure = measure;
    }


    public double convert(){
        double convertedNumber = 0;
        double toInches = 0.39;
        double toCenti = 2.54;
        if (measure == "metric"){
            convertedNumber = number * toCenti;
        }
        else if( measure == "imperial"){
            convertedNumber = number * toInches;
        }
        return convertedNumber;
    }


}
