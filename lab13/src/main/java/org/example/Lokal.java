package org.example;

import java.time.LocalDate;

public sealed abstract class Lokal permits Dom, Mieszkanie{
    private String ulica;
    private int nrDomu;
    private String miejscowosc;
    private String kodPocztowy;
    private float powierzchnia;
    private float cena;
    private LocalDate dataObowiazywania;

    public Lokal(String ulica, int nrDomu, String miejscowosc, String kodPocztowy, float powierzchnia, float cena, LocalDate dataObowiazywania) {
        this.ulica = ulica;
        this.nrDomu = nrDomu;
        this.miejscowosc = miejscowosc;
        this.kodPocztowy = kodPocztowy;
        this.powierzchnia = powierzchnia;
        this.cena = cena;
        this.dataObowiazywania = dataObowiazywania;
    }

    abstract public String myToString();

    @Override
    public String toString(){
        return "ulica: %s, nrDomu: %s, miejscowosc: %s, kod pocztowy: %s, powierzchnia: %s, cena: %s, data obowiazywania: %s,  %s".formatted(this.getUlica(), this.getNrDomu(), this.getMiejscowosc(), this.getKodPocztowy(), this.getPowierzchnia(), this.getCena(), this.getDataObowiazywania(), this.myToString());
    };


    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public int getNrDomu() {
        return nrDomu;
    }

    public void setNrDomu(int nrDomu) {
        this.nrDomu = nrDomu;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public float getPowierzchnia() {
        return powierzchnia;
    }

    public void setPowierzchnia(float powierzchnia) {
        this.powierzchnia = powierzchnia;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public LocalDate getDataObowiazywania() {
        return dataObowiazywania;
    }

    public void setDataObowiazywania(LocalDate dataObowiazywania) {
        this.dataObowiazywania = dataObowiazywania;
    }
}
