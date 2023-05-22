package org.example;

import java.time.LocalDate;

public final class Mieszkanie extends Lokal{
    private int nrMieszkania;
    private int nrPietra;
    public Mieszkanie(String ulica, int nrDomu, String miejscowosc, String kodPocztowy, float powierzchnia, float cena, LocalDate dataObowiazywania, int nrMieszkania, int nrPietra) {
        super(ulica, nrDomu, miejscowosc, kodPocztowy, powierzchnia, cena, dataObowiazywania);
        this.nrMieszkania= nrMieszkania;
        this.nrPietra= nrPietra;
    }

    public int getNrMieszkania() {
        return nrMieszkania;
    }

    public void setNrMieszkania(int nrMieszkania) {
        this.nrMieszkania = nrMieszkania;
    }

    public int getNrPietra() {
        return nrPietra;
    }

    public void setNrPietra(int nrPietra) {
        this.nrPietra = nrPietra;
    }

    @Override
    public String myToString(){
        return "nr mieszkania: %s, nr pietra: %s".formatted(this.getNrMieszkania(), this.getNrPietra());
    }
}
