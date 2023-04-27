package org.example;

import java.time.LocalTime;

public class Spotkanie {

    private String opis;
    private LocalTime poczatek;
    private LocalTime koniec;
    private Priorytet priorytet;
    private static LocalTime NAJWCZESNIEJ=LocalTime.of(10,00,00);

    public Spotkanie(){

    }

    public Spotkanie(String opis, LocalTime poczatek, LocalTime koniec, Priorytet priorytet) throws Exception{
        if(poczatek.isBefore(NAJWCZESNIEJ)) {
            throw new Exception("Nie mozna tak wczesnie");
        }
        this.opis=opis;
        this.poczatek=poczatek;
        this.koniec=koniec;
        this.priorytet=priorytet;
    }

    @Override
    public String toString() {
        return "opis: %s, poczatek: %s, koniec: %s, priorytet: %s".formatted(opis, poczatek, koniec, priorytet);
    }


    public String getOpis(){
        return this.opis;
    }

    public void setOpis(String opis){
        this.opis=opis;
    }

    public LocalTime getPoczatek(){
        return this.poczatek;
    }

    public void setPoczatek(LocalTime poczatek) throws Exception {
        if(poczatek.isBefore(NAJWCZESNIEJ)) {
            throw new Exception("nie mozna tak wczesnie");
        }
        this.poczatek = poczatek;
    }

    public LocalTime getKoniec(){
        return this.koniec;
    }

    public void setKoniec(LocalTime koniec){
        this.koniec=koniec;
    }

    public Priorytet getPriorytet(){
        return this.priorytet;
    }

    public void setPriorytet(Priorytet priorytet){
        this.priorytet=priorytet;
    }

}
