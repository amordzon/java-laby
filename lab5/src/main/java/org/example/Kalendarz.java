package org.example;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Kalendarz {
    private ArrayList<ArrayList<Wpis>> dni = new ArrayList<ArrayList<Wpis>>();
    public Kalendarz() {
        this(7);
    }

    public Kalendarz(Integer liczbaDni) {
        while (this.dni.size() < liczbaDni) {
            this.dni.add(new ArrayList<Wpis>());
        }
    }

    public void add(Integer nrDnia, String opis, LocalTime poczatek, LocalTime koniec, Priorytet priorytet) throws Exception {
        Spotkanie spotkanie = new Spotkanie(opis, poczatek, koniec, priorytet);
        dni.get(nrDnia).add(spotkanie);
    }

    public void add(Integer nrDnia, String opis, LocalTime poczatek, LocalTime koniec, Status status) throws Exception {
        Zadanie zadanie = new Zadanie(opis, poczatek, koniec, status);
        dni.get(nrDnia).add(zadanie);
    }

    public void remove(Integer nrDnia, Wpis wpisDoUsuniecia){
//        Wpis wpisDoUsuniecia=dni.get(nrDnia).get(index);
        dni.get(nrDnia).remove(wpisDoUsuniecia);
    }

    public ArrayList<Wpis> getWpisy(Integer dzien, Predicate<Wpis> warunek){
        ArrayList<Wpis> wpisDnia=dni.get(dzien);
        ArrayList<Wpis> wpisFiltrowane = new ArrayList<Wpis>();
        for (Wpis wpis : wpisDnia) {
            if(warunek.test(wpis)){
                wpisFiltrowane.add(wpis);
            }
        }
        return wpisFiltrowane;
    }
}
