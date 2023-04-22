package org.example;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Kalendarz {
    private Map<Tydzien, ArrayList<Spotkanie>> dni = new HashMap<Tydzien, ArrayList<Spotkanie>>();
    public Kalendarz() {
        this.dni.put(Tydzien.PONIEDZIALEK, new ArrayList<Spotkanie>());
        this.dni.put(Tydzien.WTOREK, new ArrayList<Spotkanie>());
        this.dni.put(Tydzien.SRODA, new ArrayList<Spotkanie>());
        this.dni.put(Tydzien.CZWARTEK, new ArrayList<Spotkanie>());
        this.dni.put(Tydzien.PIATEK, new ArrayList<Spotkanie>());
        this.dni.put(Tydzien.SOBOTA, new ArrayList<Spotkanie>());
        this.dni.put(Tydzien.NIEDZIELA, new ArrayList<Spotkanie>());
    }

    public void addSpotkanie(Tydzien dzien, String opis, LocalTime poczatek, LocalTime koniec, Priorytet priorytet) throws Exception {
        Spotkanie spotkanie = new Spotkanie(opis, poczatek, koniec, priorytet);
        dni.get(dzien).add(spotkanie);
    }

    public void removeSpotkanie(Tydzien dzien, int index){
        dni.get(dzien).remove(index);
    }

    public void getSpotkaniaDnia(Tydzien dzien) {
        for (int i=0;i<dni.get(dzien).size();i++){
            System.out.println(dni.get(dzien).get(i).toString());
        }
    }

    public ArrayList<Spotkanie> getSpotkaniaDniaPriorytet(Tydzien dzien, Priorytet priorytet) {
        ArrayList<Spotkanie> spotkaniaDnia=dni.get(dzien);
        ArrayList<Spotkanie> spotkanieDniaPriorytet= new ArrayList<>();
        for(int i = 0; i<spotkaniaDnia.size(); i++){
            if(spotkaniaDnia.get(i).getPriorytet()==priorytet) {
                spotkanieDniaPriorytet.add(spotkaniaDnia.get(i));
            }
        }
        return spotkanieDniaPriorytet;
    }
}
