package oop.exams.generator;

import oop.exams.exception.BadRegionException;

import java.util.Random;

public class CenterLicensePlateGenerator implements LicensePlateGenerator {
    @Override
    public String generate(String state) {

        if (state.charAt(0)!= 'X') {
            String digitos = "0123456789";
            int cons_length = digitos.length();

            String plate = "5";

            Random r = new Random();

            for (int i = 0; i < 7; i++) {

                plate += digitos.charAt(r.nextInt(cons_length));
            }


            return plate;
        }
        throw new BadRegionException("Allowed state codes: AGU, CMX, DUR, GUA, HID, MEX, PUE, QUE, SLP, TLA, ZAC");
    }
}

