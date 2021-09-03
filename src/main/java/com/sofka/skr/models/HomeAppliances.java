package com.sofka.skr.models;

import com.sofka.skr.enums.Consumption;

public class HomeAppliances {

    private Consumption consumption;
    private int origin;
    private double priceTotal;

    private double priceA = 450000;
    private double priceB = 350000;
    private double priceC = 250000;

    private double priceNational = 250000;
    private double priceImport = 350000;

    public HomeAppliances(Consumption consumption, int origin) {
        this.consumption = consumption;
        this.origin = origin;
    }

    public Consumption getConsumption() {
        return consumption;
    }

    public void setConsumption(Consumption consumption) {
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

    public double getPriceConsumption(Consumption type){
        switch (type){
            case A:
                return priceA;
            case  B:
                return priceB;
            case C:
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
