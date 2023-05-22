package org.example;

import java.time.LocalDate;

public final class Dom extends Lokal{
    private float powierzchniaDzialki;
    public Dom(String ulica, int nrDomu, String miejscowosc, String kodPocztowy, float powierzchnia, float cena, LocalDate dataObowiazywania, float powierzchniaDzialki) {
        super(ulica, nrDomu, miejscowosc, kodPocztowy, powierzchnia, cena, dataObowiazywania);
        this.powierzchniaDzialki= powierzchniaDzialki;
    }

    public float getPowierzchniaDzialki() {
        return powierzchniaDzialki;
    }

    public void setPowierzchniaDzialki(float powierzchniaDzialki) {
        this.powierzchniaDzialki = powierzchniaDzialki;
    }

    @Override
    public String myToString(){
        return "powierzchnia dzialki: %s".formatted(this.getPowierzchniaDzialki());
    }
}
