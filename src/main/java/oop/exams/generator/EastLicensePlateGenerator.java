package oop.exams.generator;

import oop.exams.exception.BadRegionException;

import java.util.Random;

public class EastLicensePlateGenerator implements LicensePlateGenerator {
    @Override
    public String generate(String state) {
        if(state.charAt(0)!= 'X'){
            String digitos = "0123456789";
            int cons_length = digitos.length();

            //primer digito
            String plate = "3";

            //2do y 3er digito
            Random r = new Random();
            plate += digitos.charAt(r.nextInt(cons_length));
            plate += digitos.charAt(r.nextInt(cons_length));

            //4to digito
            plate+="Z";



            return plate;


        }
        throw new BadRegionException("Allowed state codes: CAM, ROO, TAB, VER, YUC");

    }
}
