package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    static Scanner scanner= new Scanner(System.in);
    static ListaOfert listaOfert= new ListaOfert();
    public static void main(String[] args) {
        System.out.println("Program sluzy do zarzadzania lista ofert nieruchomosci.");
        boolean koniec = false;
        do{
            try {
                System.out.println("MENU\n1.Dodanie oferty domu\n2.Dodanie oferty mieszkania\n3.Wyszukanie wszystkich aktualnych ofert sprzedazy domow\n4.Wyszukanie wszystkich aktualnych ofert sprzedazy mieszkan\n5.Aktualne oferty sprzedazy domow z filtrami\n6.Aktualne ofrty sprzedazy mieszkan z filtrami\n7.Wyjscie z programu\n");
                int wybor = scanner.nextInt();
                switch (wybor) {
                    case 1 -> dodajOferteDomu();
                    case 2 -> dodajOferteMieszkania();
                    case 3 -> wyszukajOfertyDomow();
                    case 4 -> wyszukajOfertyMieszkan();
                    case 5 -> wyszukajOfertyDomowFiltr();
                    case 6 -> wyszukajOfertyMieszkanFiltr();
                    case 7 -> koniec = true;
                    default -> System.out.println("Nie ma takiej opcji w menu");
                }
            } catch (Exception e) {
                System.out.println("Wystapil blad");
            }
        } while(!koniec);
    }

    private static void dodajOferteDomu() {
        System.out.println("Podaj ulice: ");
        scanner.nextLine();
        String ulica= scanner.nextLine();
        System.out.println("Podaj numer domu: ");
        int nrDomu= scanner.nextInt();
        System.out.println("Podaj miejscowosc: ");
        scanner.nextLine();
        String miejscowosc= scanner.nextLine();
        System.out.println("Podaj kod pocztowy: ");
        String kodPocztowy= scanner.nextLine();
        System.out.println("Podaj powierzchnie: ");
        float powierzchnia= scanner.nextFloat();
        System.out.println("Podaj cene: ");
        float cena= scanner.nextFloat();
        System.out.println("Podaj powierzchnie dzialki: ");
        float powierzchniaDzialki= scanner.nextFloat();
        System.out.println("Podaj date obowiazywania: ");
        scanner.nextLine();
        String dataObowiazywaniaString= scanner.nextLine();
        LocalDate dataObowiazywania= LocalDate.parse(dataObowiazywaniaString);
        listaOfert.dodajOferte(ulica, nrDomu, miejscowosc, kodPocztowy, powierzchnia, cena, dataObowiazywania, powierzchniaDzialki);
    }

    private static void dodajOferteMieszkania() {
        System.out.println("Podaj ulice: ");
        scanner.nextLine();
        String ulica= scanner.nextLine();
        System.out.println("Podaj numer domu: ");
        int nrDomu= scanner.nextInt();
        System.out.println("Podaj miejscowosc: ");
        scanner.nextLine();
        String miejscowosc= scanner.nextLine();
        System.out.println("Podaj kod pocztowy: ");
        String kodPocztowy= scanner.nextLine();
        System.out.println("Podaj powierzchnie: ");
        float powierzchnia= scanner.nextFloat();
        System.out.println("Podaj cene: ");
        float cena= scanner.nextFloat();
        System.out.println("Podaj date obowiazywania: ");
        scanner.nextLine();
        String dataObowiazywaniaString= scanner.nextLine();
        LocalDate dataObowiazywania= LocalDate.parse(dataObowiazywaniaString);
        System.out.println("Podaj pietro: ");
        int pietro= scanner.nextInt();
        System.out.println("Podaj nr Mieszkania: ");
        int nrMieszkania= scanner.nextInt();
        listaOfert.dodajOferte(ulica, nrDomu, miejscowosc, kodPocztowy, powierzchnia, cena, dataObowiazywania, pietro, nrMieszkania);
    }

    private static void wyszukajOfertyDomow() {
        Predicate<Lokal> filtr= lokal -> lokal instanceof Dom && ((lokal.getDataObowiazywania().isAfter(LocalDate.now())) || (lokal.getDataObowiazywania().isEqual(LocalDate.now())));
        ArrayList<Lokal> listaOfertfiltr= listaOfert.getListaOftert(filtr);
        wyswietlListeOfert(listaOfertfiltr);
    }

    private static void wyszukajOfertyMieszkan() {
        Predicate<Lokal> filtr= lokal -> lokal instanceof Mieszkanie && ((lokal.getDataObowiazywania().isAfter(LocalDate.now())) || (lokal.getDataObowiazywania().isEqual(LocalDate.now())));
        ArrayList<Lokal> listaOfertfiltr= listaOfert.getListaOftert(filtr);
        wyswietlListeOfert(listaOfertfiltr);
    }

    private static void wyszukajOfertyDomowFiltr() {
        System.out.println("Podaj miejscowosc");
        scanner.nextLine();
        String miejscowosc= scanner.nextLine();
        System.out.println("Powierzchnia nie miejsza niz: ");
        float powierzchniaMin= scanner.nextFloat();
        Predicate<Lokal> filtr= lokal -> lokal instanceof Dom && (lokal.getDataObowiazywania().isAfter(LocalDate.now()) || lokal.getDataObowiazywania().isEqual(LocalDate.now())) && lokal.getMiejscowosc().equals(miejscowosc) && lokal.getPowierzchnia()>=powierzchniaMin;
        ArrayList<Lokal> listaOfertfiltr= listaOfert.getListaOftert(filtr);
        wyswietlListeOfert(listaOfertfiltr);
    }

    private static void wyszukajOfertyMieszkanFiltr() {
        System.out.println("Podaj miejscowosc");
        scanner.nextLine();
        String miejscowosc= scanner.nextLine();
        System.out.println("Nie drozsze niz: ");
        float cenaMax= scanner.nextFloat();
        System.out.println("Od ktorego pietra: ");
        int pietroMin= scanner.nextInt();
        Predicate<Lokal> filtr= lokal -> lokal instanceof Mieszkanie && (lokal.getDataObowiazywania().isAfter(LocalDate.now()) || lokal.getDataObowiazywania().isEqual(LocalDate.now())) && lokal.getMiejscowosc().equals(miejscowosc) && lokal.getCena()<=cenaMax && ((Mieszkanie)lokal).getNrPietra()>=pietroMin;
        ArrayList<Lokal> listaOfertfiltr= listaOfert.getListaOftert(filtr);
        wyswietlListeOfert(listaOfertfiltr);
    }

    private static void wyswietlListeOfert(ArrayList<Lokal> listaOfert) {
        for(Lokal lokal: listaOfert){
            System.out.println(lokal.toString());
        }
    }

}