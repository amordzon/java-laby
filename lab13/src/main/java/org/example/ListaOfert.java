package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Predicate;

public class ListaOfert {
    private ArrayList<Lokal> listaOfert= new ArrayList<Lokal>();

    public ListaOfert(){
    }

    public void dodajOferte(String ulica, int nrDomu, String miejscowosc, String kodPocztowy, float powierzchnia, float cena, LocalDate dataObowiazywania, int nrMieszkania, int nrPietra){
        Mieszkanie mieszkanie= new Mieszkanie(ulica, nrDomu, miejscowosc, kodPocztowy, powierzchnia, cena, dataObowiazywania, nrMieszkania, nrPietra);
        listaOfert.add(mieszkanie);
    }

    public void dodajOferte(String ulica, int nrDomu, String miejscowosc, String kodPocztowy, float powierzchnia, float cena, LocalDate dataObowiazywania, float powierzchniaDzialki){
        Dom dom= new Dom(ulica, nrDomu, miejscowosc, kodPocztowy, powierzchnia, cena, dataObowiazywania, powierzchniaDzialki);
        listaOfert.add(dom);
    }

    public ArrayList<Lokal> getListaOftert(Predicate<Lokal> test){
        ArrayList<Lokal> lista= new ArrayList<Lokal>();
        for(Lokal lokal: listaOfert){
            if(test.test(lokal)){
                lista.add(lokal);
            }
        }
        return lista;
    }
}
