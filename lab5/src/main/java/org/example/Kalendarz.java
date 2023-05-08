package org.example;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Kalendarz {
    private ArrayList<ArrayList<Spotkanie>> dni = new ArrayList<ArrayList<Spotkanie>>();
    public Kalendarz() {
        this(7);
    }

    public Kalendarz(Integer liczbaDni) {
        while (this.dni.size() < liczbaDni) {
            this.dni.add(new ArrayList<Spotkanie>());
        }
    }

    public void addSpotkanie(Integer nrDnia, String opis, LocalTime poczatek, LocalTime koniec, Priorytet priorytet) throws Exception {
        Spotkanie spotkanie = new Spotkanie(opis, poczatek, koniec, priorytet);
        dni.get(nrDnia).add(spotkanie);
    }

    public void removeSpotkanie(Integer nrDnia, Integer index){
        Spotkanie spotkanieDoUsuniecia=dni.get(nrDnia).get(index);
        dni.get(nrDnia).remove(spotkanieDoUsuniecia);
    }

    public ArrayList<Spotkanie> getSpotkania(Integer dzien, Predicate<Spotkanie> warunek){
        ArrayList<Spotkanie> spotkaniaDnia=dni.get(dzien);
        ArrayList<Spotkanie> spotkaniaFiltrowane = new ArrayList<Spotkanie>();
        for (Spotkanie spotkanie : spotkaniaDnia) {
            if (warunek.test(spotkanie)) {
                spotkaniaFiltrowane.add(spotkanie);
            }
        }
        return spotkaniaFiltrowane;
    }
}
