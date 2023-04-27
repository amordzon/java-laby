package org.example;

import java.time.LocalTime;
import java.util.ArrayList;

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

    public ArrayList<Spotkanie> getSpotkaniaDnia(Integer nrDnia) {
        ArrayList<Spotkanie> spotkaniaDnia=dni.get(nrDnia);
        return spotkaniaDnia;
    }

    public ArrayList<Spotkanie> getSpotkaniaDniaPriorytet(Integer nrDnia, Priorytet priorytet) {
        ArrayList<Spotkanie> spotkaniaDnia=dni.get(nrDnia);
        ArrayList<Spotkanie> spotkanieDniaPriorytet= new ArrayList<>();
        for(int i = 0; i<spotkaniaDnia.size(); i++){
            if(spotkaniaDnia.get(i).getPriorytet()==priorytet) {
                spotkanieDniaPriorytet.add(spotkaniaDnia.get(i));
            }
        }
        return spotkanieDniaPriorytet;
    }
}
