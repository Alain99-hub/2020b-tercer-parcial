package oop.exams.generator;

import oop.exams.exception.BadRegionException;

import java.util.Random;

public class NorthLicensePlateGenerator implements LicensePlateGenerator {

    @Override
    public String generate(String state) {

        if (state.charAt(0) != 'X') {
            String digitos = "0123456789";
            int cons_length = digitos.length();
            Random r = new Random();

            String plate = "1";
            plate += state;

            for (int i = 0; i < 2; i++) {

                plate += digitos.charAt(r.nextInt(cons_length));
            }
            return plate;
        }
        throw new BadRegionException("Allowed state codes: BCN, BCS, CHH, COA, NLE, SON, TAM");
    }
}
