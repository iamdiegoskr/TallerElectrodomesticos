package com.sofka.skr;

import com.sofka.skr.models.Fridge;
import com.sofka.skr.models.HomeAppliances;
import com.sofka.skr.models.Tv;

import java.util.*;

public class Main {

    static ArrayList<HomeAppliances> listProducts = new ArrayList<>();

    public static void main(String[] args) {

        Scanner lea = new Scanner(System.in);

        int option = 0;

        do{

            System.out.println("Deseas ingresar un electrodomestico ? 1.SI 0.SALIR");
            option = lea.nextInt();

            if(option==1){

                System.out.println("Que tipo de electrodomestico ?  1.Televisor 2.Nevera 3.General");
                int type = lea.nextInt();

                if (type==1){

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


                }else if(type==2){

                    System.out.println("Tipo de consumo de la nevera ? A,B,C" );
                    String consumption = lea.next().toLowerCase();

                    System.out.println("Ingrese el tipo de procedencia de la nevera? 1.Nacional 2.Importado");
                    int origin = lea.nextInt();

                    System.out.println("Ingrese la capacidad de la nevera en litros : ");
                    int capacity = lea.nextInt();

                    Fridge fridge = new Fridge(consumption.charAt(0), origin, capacity);
                    addProduct(fridge);

                    System.out.println(fridge.getPriceTotal());
                }else if(type==3){

                    System.out.println("Tipo de consumo del electrodomestico? A,B,C" );
                    String consumption = lea.next().toLowerCase();

                    System.out.println("Ingrese el tipo de procedencia del electrodomestico? 1.Nacional 2.Importado");
                    int origin = lea.nextInt();

                    HomeAppliances homeAppliances = new HomeAppliances(consumption.charAt(0),origin);
                    addProduct(homeAppliances);

                    System.out.println(homeAppliances.getPriceTotal());

                }
            }

        }while(option!=0);

        showListProducts();


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
