package org.example;

import java.time.LocalTime;

public final class Spotkanie extends Wpis{
    private Priorytet priorytet;

    public Spotkanie(){

    }

    public Spotkanie(String opis, LocalTime poczatek, LocalTime koniec, Priorytet priorytet) throws Exception{
        super(opis, poczatek, koniec);
        this.priorytet=priorytet;
    }

    @Override
    public String myToString() {
        return "priorytet: %s".formatted(priorytet);
    }


    public Priorytet getPriorytet(){
        return this.priorytet;
    }

    public void setPriorytet(Priorytet priorytet){
        this.priorytet=priorytet;
    }

}
