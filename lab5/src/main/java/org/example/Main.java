package org.example;
import java.time.LocalTime;
import java.util.Scanner;
public class Main {
    static Scanner reader = new Scanner(System.in);
    static Kalendarz kalendarz = new Kalendarz();
    public static void main(String[] args) throws Exception {
        try{
            System.out.println("Program sluzy do tworzenia spotkan w dane dni");
            boolean koniec = false;
            do{
                System.out.println("1.Dodaj spotkanie na wybrany dzien\n2.Usun spotkanie z wybranego dnia\n3. Wyswietl wszystkie spotkania danego dnia\n4.Wyswietl wszystkie spotkania danego dnia o danym priorytecie\n5.Koniec");
                int wybor= reader.nextInt();
                switch (wybor) {
                    case 1 -> createSpotkanieCase();
                    case 2 -> usunSpotkanieCase();
                    case 3 -> pokazSpotkaniaCase();
                    case 4 -> pokazSpotkaniaPriorytetCase();
                    case 5 -> koniec = true;
                    default -> System.out.println("nie ma takiej opcji");
                }
            } while(koniec!=true);

        } catch (Exception e){
            System.out.println("blad");
        }
    }

    public static void createSpotkanieCase() throws Exception {
        System.out.println("Podaj opis spotkania");
        String opis = reader.next();
        System.out.println("Podaj godzine rozpoczecia: ");
        String poczatek = reader.next();
        LocalTime poczatekCzas = LocalTime.parse(poczatek);
        System.out.println("Podaj godzine zakonczenia: ");
        String zakonczenie = reader.next();
        LocalTime zakonczenieCzas = LocalTime.parse(zakonczenie);
        System.out.println("Podaj priorytet: ");
        Priorytet priorytet = Priorytet.valueOf(reader.next().toUpperCase());
        System.out.println("Podaj dzien tygodnia: ");
        Tydzien tydzien = Tydzien.valueOf(reader.next().toUpperCase());
        kalendarz.addSpotkanie(tydzien, opis, poczatekCzas, zakonczenieCzas, priorytet);
    }

    public static void usunSpotkanieCase() throws Exception {
        System.out.println("z ktorego dnia ");
        Tydzien dzien = Tydzien.valueOf(reader.next().toUpperCase());
        kalendarz.getSpotkaniaDnia(dzien);
        System.out.println("podaj index ");
        int index = reader.nextInt();
        kalendarz.removeSpotkanie(dzien, index);
    }

    public static void pokazSpotkaniaCase() throws Exception {
        System.out.println("z ktorego dnia ");
        Tydzien dzienSpotkania = Tydzien.valueOf(reader.next().toUpperCase());
        kalendarz.getSpotkaniaDnia(dzienSpotkania);
    }

    public static void pokazSpotkaniaPriorytetCase() throws Exception {
        System.out.println("z ktorego dnia ");
        Tydzien dzienSpotkaniaDoUsuniecia = Tydzien.valueOf(reader.next().toUpperCase());
        System.out.println("Podaj priorytet: ");
        Priorytet priorytetSpotkania = Priorytet.valueOf(reader.next().toUpperCase());
        System.out.println(kalendarz.getSpotkaniaDniaPriorytet(dzienSpotkaniaDoUsuniecia,priorytetSpotkania));
    }
}