package com.aligunes;

public abstract class Personel {

    protected String name;
    protected String surname;
    protected ERole role;
    protected int calismaSaati;



    public Personel(String name, String surname, ERole role, int calismaSaati) {
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.calismaSaati=calismaSaati;

    }

    public Personel() {
    }

    public abstract double maasHesapla();

    // Getters and setters
}
