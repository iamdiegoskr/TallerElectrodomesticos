package com.sofka.skr;

import com.sofka.skr.models.Fridge;
import com.sofka.skr.models.HomeAppliances;
import com.sofka.skr.models.Tv;

import javax.swing.*;
import java.util.*;

public class Main {

    static ArrayList<HomeAppliances> listProducts = new ArrayList<>();

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

        System.out.println("Tipo de consumo del televisor? A,B,C" );
        String consumption = lea.next().toLowerCase();

        System.out.println("Ingrese el tipo de procedencia del tv? 1.Nacional 2.Importado");
        int origin = lea.nextInt();

        System.out.println("Ingrese el numero de pulgadas");
        int inches = lea.nextInt();

        System.out.println("El televisor tiene tdt ? 1.SI 2.NO");
        int haveTdt = lea.nextInt();

        Tv tv = new Tv(consumption.charAt(0), origin, inches, haveTdt);
        addProduct(tv);

        System.out.println(tv.getPriceTotal());
    }

    public static void registerFridge(){
        System.out.println("Tipo de consumo de la nevera ? A,B,C" );
        String consumption = lea.next().toLowerCase();

        System.out.println("Ingrese el tipo de procedencia de la nevera? 1.Nacional 2.Importado");
        int origin = lea.nextInt();

        System.out.println("Ingrese la capacidad de la nevera en litros : ");
        int capacity = lea.nextInt();

        Fridge fridge = new Fridge(consumption.charAt(0), origin, capacity);
        addProduct(fridge);

        System.out.println(fridge.getPriceTotal());
    }

    public static void registerHomeAppliance(){
        System.out.println("Tipo de consumo del electrodomestico? A,B,C" );
        String consumption = lea.next().toLowerCase();

        System.out.println("Ingrese el tipo de procedencia del electrodomestico? 1.Nacional 2.Importado");
        int origin = lea.nextInt();

        HomeAppliances homeAppliances = new HomeAppliances(consumption.charAt(0),origin);
        addProduct(homeAppliances);

        System.out.println(homeAppliances.getPriceTotal());
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

        System.out.println("VALOR TOTAL A PAGAR = " + priceAllProducts);

    }

}
