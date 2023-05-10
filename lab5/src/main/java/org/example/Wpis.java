package org.example;

import java.time.LocalTime;

public sealed abstract class Wpis permits Spotkanie, Zadanie{
    private String opis;
    private LocalTime poczatek;
    private LocalTime koniec;
    public static final LocalTime NAJWCZESNIEJ=LocalTime.of(10,00,00);

    public Wpis(){

    }

    public Wpis(String opis, LocalTime poczatek, LocalTime koniec) throws Exception{
        if(poczatek.isBefore(NAJWCZESNIEJ)) {
            throw new Exception("Nie mozna tak wczesnie");
        }
        this.opis=opis;
        this.poczatek=poczatek;
        this.koniec=koniec;
    }

    abstract public String myToString();

    @Override
    public String toString(){
        return "opis: %s, poczatek: %s, koniec: %s, %s".formatted(this.getOpis(), this.getPoczatek(), this.getKoniec(), this.myToString());
    };


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
}
