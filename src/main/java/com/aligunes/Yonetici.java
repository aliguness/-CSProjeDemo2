package com.aligunes;

public class Yonetici extends Personel{

    protected double saatlikUcret;
    protected double bonus;


    public Yonetici(String name, String surname, double saatlikUcret, double bonus, int calismaSaati) {
        super(name, surname, ERole.YONETICI,calismaSaati);
        this.saatlikUcret = (saatlikUcret < 500) ? 500 : saatlikUcret;
        this.bonus = bonus;
    }

    @Override
    public double maasHesapla() {
        double toplamMaas = calismaSaati*saatlikUcret;

        return toplamMaas;
    }
}
