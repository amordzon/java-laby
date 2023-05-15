package org.example;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    static Scanner reader = new Scanner(System.in);
    static Kalendarz kalendarz = new Kalendarz(10);
    public static void main(String[] args) throws Exception {
            System.out.println("Program sluzy do tworzenia spotkan w dane dni");
            boolean koniec = false;
            do{
                try{
                    System.out.println("1.Dodaj spotkanie na wybrany dzien\n2.Dodaj zadania na wybrany dzien\n3.Usun spotkanie z dnia\n4.Usun zadanie z dnia\n5.Wyswietl wszystkie spotkania z dnia.\n6.Wyswietl wszystkie zadania z dnia\n7.Spotkania o danym priorytecie\n8.Zadania o danym statusie\n9.Spotkania o wybranym priorytecie i od podanego czasu\n10.Zadania w danym dniu i konczace sie nie pozniej niz podany czas\n11.Koniec");
                    Integer wybor= reader.nextInt();
                    switch (wybor) {
                        case 1 -> createSpotkanieCase();
                        case 2 -> createZadanieCase();
                        case 3 -> usunSpotkanieCase();
                        case 4 -> usunZadanieCase();
                        case 5 -> pokazSpotkaniaCase();
                        case 6 -> pokazZadaniaCase();
                        case 7 -> pokazSpotkaniaPriorytetCase();
                        case 8 -> pokazZadaniaStatusCase();
                        case 9 -> pokazSpotkaniaDniaCzasPriorytetCase();
                        case 10 -> pokazZadaniaDniaCzasStatusCase();
                        case 11 -> koniec = true;
                        default -> System.out.println("nie ma takiej opcji");
                    }
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            } while(koniec!=true);
    }

    public static void createSpotkanieCase() throws Exception {
        System.out.println("Podaj opis spotkania:");
        reader.nextLine();
        String opis = reader.nextLine();
        System.out.println("Podaj godzine rozpoczecia: ");
        String poczatek = reader.next();
        LocalTime poczatekCzas = LocalTime.parse(poczatek);
        System.out.println("Podaj godzine zakonczenia: ");
        String zakonczenie = reader.next();
        LocalTime zakonczenieCzas = LocalTime.parse(zakonczenie);
        System.out.println("Podaj priorytet: ");
        Priorytet priorytet = Priorytet.valueOf(reader.next().toUpperCase());
        System.out.println("Podaj ktory dzien (od 1): ");
        Integer dzien = reader.nextInt();
        kalendarz.add(dzien-1, opis, poczatekCzas, zakonczenieCzas, priorytet);
    }

    public static void createZadanieCase() throws Exception {
        System.out.println("Podaj opis zadania:");
        reader.nextLine();
        String opis = reader.nextLine();
        System.out.println("Podaj godzine rozpoczecia: ");
        String poczatek = reader.next();
        LocalTime poczatekCzas = LocalTime.parse(poczatek);
        System.out.println("Podaj godzine zakonczenia: ");
        String zakonczenie = reader.next();
        LocalTime zakonczenieCzas = LocalTime.parse(zakonczenie);
        System.out.println("Podaj status: ");
        Status status = Status.valueOf(reader.next().toUpperCase());
        System.out.println("Podaj ktory dzien (od 1): ");
        Integer dzien = reader.nextInt();
        kalendarz.add(dzien-1, opis, poczatekCzas, zakonczenieCzas, status);
    }

    public static void usunSpotkanieCase() throws Exception {
        System.out.println("z ktorego dnia (od 1)");
        Integer dzien = reader.nextInt();
        Predicate<Wpis> warunek = s -> s instanceof Spotkanie;
        ArrayList<Wpis> spotkania = kalendarz.getWpisy(dzien-1, warunek);
        printujSpotkania(spotkania);
        System.out.println("podaj index (od 0):");
        int index = reader.nextInt();
        kalendarz.remove(dzien-1, spotkania.get(index));
    }

    public static void usunZadanieCase() throws Exception {
        System.out.println("z ktorego dnia (od 1)");
        Integer dzien = reader.nextInt();
        Predicate<Wpis> warunek = s -> s instanceof Zadanie;
        ArrayList<Wpis> zadania = kalendarz.getWpisy(dzien-1, warunek);
        printujSpotkania(zadania);
        System.out.println("podaj index (od 0):");
        int index = reader.nextInt();
        kalendarz.remove(dzien-1, zadania.get(index));
    }

    public static void pokazSpotkaniaCase() throws Exception {
        System.out.println("z ktorego dnia (od 1):");
        Integer dzien = reader.nextInt();
        Predicate<Wpis> warunek = s -> s instanceof Spotkanie;
        ArrayList<Wpis> spotkania = kalendarz.getWpisy(dzien-1, warunek);
        printujSpotkania(spotkania);
    }

    public static void pokazZadaniaCase() throws Exception {
        System.out.println("z ktorego dnia (od 1):");
        Integer dzien = reader.nextInt();
        Predicate<Wpis> warunek = s -> s instanceof Zadanie;
        ArrayList<Wpis> zadania = kalendarz.getWpisy(dzien-1, warunek);
        printujSpotkania(zadania);
    }

    public static void pokazSpotkaniaPriorytetCase() throws Exception {
        System.out.println("z ktorego dnia (od 1):");
        Integer dzien = reader.nextInt();
        System.out.println("Podaj priorytet: ");
        Priorytet priorytetSpotkania = Priorytet.valueOf(reader.next().toUpperCase());
        Predicate<Wpis> warunek = s -> s instanceof Spotkanie && ((Spotkanie) s).getPriorytet() == priorytetSpotkania;
        ArrayList<Wpis> spotkania = kalendarz.getWpisy(dzien-1, warunek);
        printujSpotkania(spotkania);
    }

    public static void pokazZadaniaStatusCase() throws Exception {
        System.out.println("z ktorego dnia (od 1):");
        Integer dzien = reader.nextInt();
        System.out.println("Podaj status: ");
        Status statusZadania = Status.valueOf(reader.next().toUpperCase());
        Predicate<Wpis> warunek = s -> s instanceof Zadanie && ((Zadanie) s).getStatus() == statusZadania;
        ArrayList<Wpis> zadania = kalendarz.getWpisy(dzien-1, warunek);
        printujSpotkania(zadania);
    }

    public static void pokazSpotkaniaDniaCzasCase() throws Exception {
        System.out.println("z ktorego dnia (od 1):");
        Integer dzien = reader.nextInt();
        System.out.println("Od ktorej godziny: ");
        String poczatek = reader.next();
        LocalTime czas = LocalTime.parse(poczatek);
        Predicate<Wpis> warunek = s -> s instanceof Spotkanie && s.getPoczatek().isAfter(czas) || s.getPoczatek().equals(czas);
        ArrayList<Wpis> spotkania = kalendarz.getWpisy(dzien-1, warunek);
        printujSpotkania(spotkania);
    }

    public static void pokazSpotkaniaDniaCzasyCase() throws Exception {
        System.out.println("z ktorego dnia (od 1):");
        Integer dzien = reader.nextInt();
        System.out.println("Od ktorej godziny: ");
        String poczatek = reader.next();
        LocalTime czasPoczatek = LocalTime.parse(poczatek);
        System.out.println("Do ktorej godziny: ");
        String koniec = reader.next();
        LocalTime czasKoniec = LocalTime.parse(koniec);
        Predicate<Wpis> warunek = s -> s instanceof Spotkanie && ((s.getPoczatek().isAfter(czasPoczatek) || s.getPoczatek().equals(czasPoczatek)) && (s.getPoczatek().isBefore(czasKoniec) || s.getPoczatek().equals(czasKoniec)));
        ArrayList<Wpis> spotkania = kalendarz.getWpisy(dzien-1, warunek);
        printujSpotkania(spotkania);
    }

    public static void pokazSpotkaniaDniaCzasPriorytetCase() throws Exception {
        System.out.println("z ktorego dnia (od 1):");
        Integer dzien = reader.nextInt();
        System.out.println("Podaj priorytet: ");
        Priorytet priorytetSpotkania = Priorytet.valueOf(reader.next().toUpperCase());
        System.out.println("Od ktorej godziny: ");
        String poczatek = reader.next();
        LocalTime czasPoczatek = LocalTime.parse(poczatek);
        Predicate<Wpis> warunek = s -> s instanceof Spotkanie && ((s.getPoczatek().isAfter(czasPoczatek) || s.getPoczatek().equals(czasPoczatek)) && (((Spotkanie) s).getPriorytet()==priorytetSpotkania));
        ArrayList<Wpis> spotkania = kalendarz.getWpisy(dzien-1, warunek);
        printujSpotkania(spotkania);
    }

    public static void pokazZadaniaDniaCzasStatusCase() throws Exception {
        System.out.println("z ktorego dnia (od 1):");
        Integer dzien = reader.nextInt();
        System.out.println("Podaj status: ");
        Status statusZadania = Status.valueOf(reader.next().toUpperCase());
        System.out.println("Do ktorej godziny: ");
        String koniec = reader.next();
        LocalTime czasKoniec = LocalTime.parse(koniec);
        Predicate<Wpis> warunek = s -> s instanceof Zadanie && ((s.getKoniec().isBefore(czasKoniec) || s.getKoniec().equals(czasKoniec)) && (((Zadanie) s).getStatus()==statusZadania));
        ArrayList<Wpis> spotkania = kalendarz.getWpisy(dzien-1, warunek);
        printujSpotkania(spotkania);
    }

    public static void printujSpotkania(ArrayList<Wpis> wpisy){
        for (Wpis wpis : wpisy) {
            System.out.println(wpis);
        }
    }
}