package com.aligunes;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class MaasBordro {
    public static void rapor(JSONArray personelListesi) {

        try {
            for (Object obj : personelListesi) {
                JSONObject personel = (JSONObject) obj;
                String name= (String) personel.get("name");
                String role= (String) personel.get("role");

                double calismaSaati=Double.parseDouble(personel.get("calismaSaati").toString());
                double saatlikUcret=Double.parseDouble(personel.get("saatlikUcret").toString());
                double anaOdeme3=0;
                double anaOdeme4=0;
                double anaOdeme5=0;

                if (role.equals("Yonetici")){
                    double bonus=Double.parseDouble(personel.get("bonus").toString());
                    anaOdeme3=calismaSaati*saatlikUcret+bonus;
                }else {
                    if (calismaSaati>180){
                        anaOdeme3=180*saatlikUcret;
                        anaOdeme4=(calismaSaati-180)*saatlikUcret*1.5;
                        anaOdeme5=anaOdeme3+anaOdeme4;
                    }else{
                        anaOdeme3=calismaSaati*saatlikUcret;
                    }
                }


                String dosyaAdi = name+" " + LocalDate.now().getMonth() + " " + LocalDate.now().getYear() + ".json";

                try (FileWriter file = new FileWriter(dosyaAdi)) {
                    file.write("{\n");
                    file.write("\"bordro\": \"" + LocalDate.now().getMonth() + " " + LocalDate.now().getYear() + "\",\n");
                    file.write("\"personel\": {\n");
                    file.write("\"ismi\": \"" + name + "\",\n");
                    file.write("\"calismaSaati\": " + personel.get("calismaSaati") + ",\n");
                    file.write("\"odemeDetaylari\": {\n");
                    if (role.equals("Yonetici")){
                        file.write("\"anaOdeme\": \"" +String.format("%.2f",anaOdeme3) + "\",\n");
                        file.write("\"mesai\": \"" + String.format("%.2f",anaOdeme4) + "\",\n");
                        file.write("\"toplamOdeme\": \"" + String.format("%.2f",anaOdeme3) + "\"\n");
                    }
                    if (role.equals("Memur")){
                        file.write("\"anaOdeme\": \"" +String.format("%.2f",anaOdeme3) + "\",\n");
                        file.write("\"mesai\": \"" + String.format("%.2f",anaOdeme4) + "\",\n");
                        file.write("\"toplamOdeme\": \"" + String.format("%.2f",anaOdeme5) + "\"\n");
                    }


                    file.write("}\n");
                    file.write("}\n");
                    file.write("}");
                    file.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Maaş bordrosu başarıyla kaydedildi.");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

