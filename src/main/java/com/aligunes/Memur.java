package com.aligunes;

public class Memur extends Personel {

    protected double saatlikUcret;
    protected EDerece derece;


    public Memur(String name, String surname, EDerece derece, int calismaSaati) {
        super(name, surname, ERole.MEMUR,calismaSaati);
        this.saatlikUcret = 500; // standart saatlik ucret
        this.derece = derece;
    }

    public Memur() {
        super();
    }

    @Override
    public double maasHesapla() {
        double toplamMaas;

        if (calismaSaati > 180){
            toplamMaas = 180*saatlikUcret+(calismaSaati-180)*(saatlikUcret*1.5);
            return toplamMaas;
        }else {
            toplamMaas=calismaSaati*saatlikUcret;
            return toplamMaas;
        }



    }

}
