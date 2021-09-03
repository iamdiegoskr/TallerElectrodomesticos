package com.sofka.skr.models;

import com.sofka.skr.enums.Consumption;

public class Tv extends HomeAppliances{

    private int inches;
    private int haveTdt;

    public Tv(Consumption consumption, int origin, int inches, int haveTdt) {
        super(consumption, origin);
        this.inches = inches;
        this.haveTdt = haveTdt;
    }

    public int getInches() {
        return inches;
    }

    public void setInches(int inches) {
        this.inches = inches;
    }

    public int isHaveTdt() {
        return haveTdt;
    }

    public void setHaveTdt(int haveTdt) {
        this.haveTdt = haveTdt;
    }

    @Override
    public double getPriceTotal() {

        double priceBase = super.getPriceTotal();

        if(inches>40){
            priceBase = priceBase + priceBase*0.3;
        }
        if(haveTdt==1){
            priceBase+= 250000;
        }

        return priceBase;
    }

    public String isTdt(){
        return (haveTdt==1)? "SI TIENE" : "NO TIENE";
    }

    @Override
    public String toString() {
        return "Televisor -> " + " \n" +
                 "Precio"+ getPriceTotal() + " \n" +
                "Consumo = " + super.getConsumption()  + " \n" +
                "Importado = " + super.getOrigin() + " \n" +
                "Tdt ? " + isTdt();
    }
}
