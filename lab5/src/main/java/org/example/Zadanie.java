package org.example;

import java.time.LocalTime;

public final class Zadanie extends Wpis{

    private Status status;
    public Zadanie(){

    }

    public Zadanie(String opis, LocalTime poczatek, LocalTime koniec, Status status) throws Exception{
        super(opis, poczatek, koniec);
        this.status=status;
    }

    public Status getStatus(){
        return this.status;
    }

    public void setStatus(Status status){
        this.status=status;
    }

    @Override
    public String myToString() {
        return "status: %s".formatted(status);
    }
}
