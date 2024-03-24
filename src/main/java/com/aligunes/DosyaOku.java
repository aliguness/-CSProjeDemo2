package com.aligunes;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DosyaOku {

    public static JSONArray oku(String dosyaYolu) {
        JSONArray personelListesi = new JSONArray();
        JSONParser parser = new JSONParser();
        Scanner scanner=new Scanner(System.in);

        try {
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(dosyaYolu));
            personelListesi.addAll(jsonArray);
            for (Object obj:personelListesi){
                JSONObject personel= (JSONObject) obj;
                System.out.println(obj.toString());
                System.out.println("Lütfen personelin çalışma saatini giriniz.");
                int calismaSaati=scanner.nextInt();
                personel.put("calismaSaati",calismaSaati);
                System.out.println("Lütfen personelin saatlik ücretini giriniz.");
                int saatlikUcret=scanner.nextInt();
                personel.put("saatlikUcret",saatlikUcret);

                String role = (String) personel.get("role");
                if (role.equals("Yonetici")) {
                    System.out.println("Bonus miktarini giriniz: ");
                    double bonus = scanner.nextDouble();
                    personel.put("bonus", bonus);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return personelListesi;
    }



}