package org.example;

public class Walec {
    private double promien;
    private double wysokosc;

    public Walec(double promien, double wysokosc){
        this.promien=promien;
        this.wysokosc=wysokosc;
    }

    public Walec(){
    }

    public double getPromien(){
        return this.promien;
    }

    public void setPromien(double promien){
        this.promien=promien;
    }

    public double getWysokosc(){
        return this.wysokosc;
    }

    public void setWysokosc(double wysokosc){
        this.wysokosc = wysokosc;
    }

    public double polePowierzchniPodstawy(){
        return Math.PI*Math.pow(promien,2);
    }

    public double polePowierzchniBocznej(){
        return 2*Math.PI*promien*wysokosc;
    }

    public double polePowierzchniCalkowitej(){
        return 2*polePowierzchniPodstawy()+polePowierzchniBocznej();
    }

    public double objetosc(){
        return polePowierzchniPodstawy()*wysokosc;
    }

}
