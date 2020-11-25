package oop.exams.generator;

import oop.exams.exception.BadRegionException;

import java.util.Random;

public class SouthLicensePlateGenerator implements LicensePlateGenerator{
    @Override
    public String generate(String state) {
        if (state.charAt(0) != 'X') {
            String digits = "0123456789";
            int cons_length = digits.length();
            Random r = new Random();

            //1er digito
            String plate = "4";

            plate += state;

            for (int i = 0; i < 3; i++) {

                plate += digits.charAt(r.nextInt(cons_length));
            }
            return plate;
        }
        throw new BadRegionException("Allowed state codes: CHP, GRO, MIC, OAX");
    }
}

