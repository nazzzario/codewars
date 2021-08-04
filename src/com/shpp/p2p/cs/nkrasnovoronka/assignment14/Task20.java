package com.shpp.p2p.cs.nkrasnovoronka.assignment14;

import java.util.List;
import java.util.Map;

public class Task20 {
    public static void main(String[] args) {

    }

    public void receiveBulletin(String bulletin) {
        // Your code here
    }

    public String inspect(Map<String, String> person) {
        // Your code here
        return "";
    }

    enum Cities{
        ARSTOTZKA, ANTEGRIO, IMPOR, KOLECHIA, OBRISTAN, REPUBLIA, UNITED_FEDERETION;
    }

    enum Document{
        PASSPORT, CERTIFICATE_OF_VACATION, ID_CARD, ACCESS_PERMIT, WORK_PASS, GRANT_OF_ASYLUM, DIPLOMATIC_AUTHORIZATION
    }

    class Bulletin{
        List<Cities> allowedCities;
        List<Cities> bannedCities;

        public Bulletin(String text) {

        }
    }
}
