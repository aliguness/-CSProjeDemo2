package com.aligunes;

import org.json.simple.JSONArray;

import java.util.List;

public class AppMain {
    public static void main(String[] args) {

        JSONArray personelList = DosyaOku.oku("src/main/java/com/aligunes/ornek.json");
        MaasBordro.rapor(personelList);

    }
}