package com.sofka.skr.models;

import com.sofka.skr.enums.Consumption;
import com.sofka.skr.enums.Origin;

public class Fridge extends HomeAppliances {

    private int capacity;
    private final int ADDICTION_CAPACITY = 10;

    public Fridge(Consumption consumption, Origin origin, int capacity) {
        super(consumption, origin);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public double getPriceTotal() {

        double priceBase = super.getPriceTotal();

        if(capacity>120){

            double additionalCapacity = capacity-120; // 140 -> 20

            double quantityAddiction = additionalCapacity/ADDICTION_CAPACITY; // 20/10 -> 2

            double SurplusPrice = 0;

            if(quantityAddiction>=1){
                SurplusPrice = quantityAddiction*(priceBase*0.05);
            }
            priceBase+=SurplusPrice;
        }
        return priceBase;
    }

    @Override
    public String toString() {
        return "NEVERA -> {" + " \n" +
                "Precio : " + getPriceTotal() +
                "Tipo de consumo : " + super.getConsumption() + " \n" +
                "Orgines : " + super.getOrigin() + " \n" +
                "Capacidad :" + capacity;
    }
}
