package com.sofka.skr.models;

public class HomeAppliances {

    private char consumption;
    private int origin;
    private double priceTotal;

    private double priceA = 450000;
    private double priceB = 350000;
    private double priceC = 250000;

    private double priceNational = 250000;
    private double priceImport = 350000;

    public HomeAppliances(char consumption, int origin) {
        this.consumption = consumption;
        this.origin = origin;
    }

    public char getConsumption() {
        return consumption;
    }

    public void setConsumption(char consumption) {
        this.consumption = consumption;
    }

    public int getOrigin() {
        return origin;
    }

    public void setOrigin(int origin) {
        this.origin = origin;
    }

    public double getPriceTotal() {
        priceTotal = getPriceConsumption(consumption) + getPriceOrigin(origin) ;
        return priceTotal;
    }

    public void setPriceTotal(double priceTotal) {
        this.priceTotal = priceTotal;
    }

    public double getPriceConsumption(char type){
        switch (type){
            case 'a':
                return priceA;
            case  'b':
                return priceB;
            case 'c':
                return priceC;
            default:
                return 0;
        }
    }

    public double getPriceOrigin(int origin){

        switch (origin){
            case 1:
                return priceNational;
            case 2:
                return priceImport;
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return "Electrodomestico general -> " + getPriceTotal();
    }
}
