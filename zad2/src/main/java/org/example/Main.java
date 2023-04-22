package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program liczby pola powierzchni oraz objetosc walca dla podanych wartosci");
        Scanner input = new Scanner(System.in);
        Walec cylinder = new Walec();
        boolean koniec = false;
        while(!koniec){
            System.out.println("Menu\n1.Wyswietl wartosc zmiennych instacji obiektu.\n2.Zmien wartosc zmiennych instancji obiektu.\n3.Wyswietl pola powierzchni i obietosci.\n4.Wyjscie z programu");
            int wybor = input.nextInt();
            switch(wybor){
                case 1:
                    System.out.println("Wysokosc: "+cylinder.getWysokosc());
                    System.out.println("Promien: "+cylinder.getPromien());
                    break;
                case 2:
                    System.out.println("Podaj wysokosc walca: ");
                    double wysokosc = input.nextDouble();
                    System.out.println("Podaj promien walca: ");
                    double promien = input.nextDouble();
                    cylinder.setWysokosc(wysokosc);
                    cylinder.setPromien(promien);
                    break;
                case 3:
                    System.out.println("Pole powierzchni podstawy walca wynosi: "+cylinder.polePowierzchniPodstawy());
                    System.out.println("Pole powierzchni bocznej walca wynosi: "+cylinder.polePowierzchniBocznej());
                    System.out.println("Pole powierzchni calkowitej walca wynosi: "+cylinder.polePowierzchniCalkowitej());
                    System.out.println("Objetosc walca wynosi: "+cylinder.objetosc());
                    break;
                case 4:
                    koniec=true;
                    break;
                default:
                    System.out.println("Zla opcja z menu!");
            }
        }
        System.out.println("Koniec programu");

    }
}