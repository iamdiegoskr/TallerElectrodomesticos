package com.sofka.skr;

import com.sofka.skr.enums.Consumption;
import com.sofka.skr.enums.Origin;
import com.sofka.skr.models.Fridge;
import com.sofka.skr.models.HomeAppliances;
import com.sofka.skr.models.Tv;

import javax.swing.*;
import java.util.*;

public class Main {

    static ArrayList<HomeAppliances> listProducts = new ArrayList<>();

    static Consumption[] listTypeConsumption = {Consumption.A,Consumption.B,Consumption.C};
    static Origin[] listOrigin = {Origin.NACIONAL,Origin.IMPORTADO};

    static Scanner lea = new Scanner(System.in);

    public static void main(String[] args) {

        int option = 0;

        do{
            option = Integer.parseInt
                    (JOptionPane.showInputDialog("Desea ingresar un electrodomestico ? 1.SI 0.SALIR"));

            if(option==1){

                int type = Integer.parseInt(JOptionPane.
                        showInputDialog("Que tipo de electrodomestico ?  1.Televisor 2.Nevera 3.General"));

                switch (type){
                    case 1 :
                        registerTv();
                        break;
                    case 2:
                        registerFridge();
                        break;
                    case 3:
                        registerHomeAppliance();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Ingresaste una opcion invalida",
                                "Hey!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }while(option!=0);
        showListProducts();
    }

    public static void registerTv(){

        Consumption typeConsumption = getConsumption("Televisor");
        Origin origin = getOrigin("Televisor");
        int inches = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de pulgadas"));
        int haveTdt = Integer.parseInt(JOptionPane.showInputDialog("El televisor tiene tdt ? 1.SI 2.NO"));

        Tv tv = new Tv(typeConsumption, origin, inches, haveTdt);
        addProduct(tv);
    }

    public static void registerFridge(){
        Consumption typeConsumption = getConsumption("Nevera");
        Origin origin = getOrigin("Nevera");
        int capacity = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad de la nevera en litros : "));

        Fridge fridge = new Fridge(typeConsumption, origin, capacity);
        addProduct(fridge);
    }

    public static void registerHomeAppliance(){
        Consumption typeConsumption = getConsumption("Electromestico");

        Origin origin = getOrigin("Electrodomestico");

        HomeAppliances homeAppliances = new HomeAppliances(typeConsumption,origin);
        addProduct(homeAppliances);
    }


    public static Consumption getConsumption(String type){
        return (Consumption)JOptionPane.showInputDialog(null, "Tipo de consumo ?",
                type, JOptionPane.QUESTION_MESSAGE, null,
                listTypeConsumption,
                listTypeConsumption[0]);
    }
    
    public static Origin getOrigin(String type){
        return (Origin) JOptionPane.showInputDialog(null, "Tipo de consumo ?",
                type, JOptionPane.QUESTION_MESSAGE, null,
                listOrigin,
                listOrigin[0]);
    }

    public static void addProduct(HomeAppliances product ){
        listProducts.add(product);
    }

    public static void showListProducts(){
        for (HomeAppliances product : listProducts){
            System.out.println(product.toString());
            System.out.println();
        }
        showPriceTotalAllProducts();
    }

    public static void showPriceTotalAllProducts(){

        double priceAllProducts = 0;

        for (HomeAppliances product : listProducts){
            priceAllProducts += product.getPriceTotal();
        }
        System.out.println("------------------------");
        System.out.println("VALOR TOTAL A PAGAR = " + priceAllProducts);

    }

}
