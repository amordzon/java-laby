package org.example;
import java.time.LocalTime;
import java.util.Scanner;
public class Main {
    static Scanner reader = new Scanner(System.in);
    static Kalendarz kalendarz = new Kalendarz(10);
    public static void main(String[] args) throws Exception {

            System.out.println("Program sluzy do tworzenia spotkan w dane dni");
            boolean koniec = false;
            do{
                try{
                    System.out.println("1.Dodaj spotkanie na wybrany dzien\n2.Usun spotkanie z wybranego dnia\n3.Wyswietl wszystkie spotkania danego dnia\n4.Wyswietl wszystkie spotkania danego dnia o danym priorytecie\n5.Koniec");
                    Integer wybor= reader.nextInt();
                    switch (wybor) {
                        case 1 -> createSpotkanieCase();
                        case 2 -> usunSpotkanieCase();
                        case 3 -> pokazSpotkaniaCase();
                        case 4 -> pokazSpotkaniaPriorytetCase();
                        case 5 -> koniec = true;
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
        kalendarz.addSpotkanie(dzien-1, opis, poczatekCzas, zakonczenieCzas, priorytet);
    }

    public static void usunSpotkanieCase() throws Exception {
        System.out.println("z ktorego dnia (od 1)");
        System.out.println("Podaj dzien tygodnia: ");
        Integer dzien = reader.nextInt();
        System.out.println(kalendarz.getSpotkaniaDnia(dzien-1));
        System.out.println("podaj index (od 0):");
        int index = reader.nextInt();
        kalendarz.removeSpotkanie(dzien-1, index);
    }

    public static void pokazSpotkaniaCase() throws Exception {
        System.out.println("z ktorego dnia (od 1):");
        Integer dzien = reader.nextInt();
        System.out.println(kalendarz.getSpotkaniaDnia(dzien-1));
    }

    public static void pokazSpotkaniaPriorytetCase() throws Exception {
        System.out.println("z ktorego dnia (od 1):");
        Integer dzien = reader.nextInt();
        System.out.println("Podaj priorytet: ");
        Priorytet priorytetSpotkania = Priorytet.valueOf(reader.next().toUpperCase());
        System.out.println(kalendarz.getSpotkaniaDniaPriorytet(dzien-1,priorytetSpotkania));
    }
}