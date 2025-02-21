package OperacionsSistRepr;

import java.util.Scanner;

public class BinariAHexa {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Introdueix el nombre en binari: ");
        long binari = input.nextLong();

        String hexa = "";

        while (binari != 0) {
            int r = (int) (binari % 10000);
            String ndhexa = digitAHexa(binariDecimal(r));
            hexa = ndhexa + hexa;
            binari = binari / 10000;
        }
        System.out.printf("El nombre %d en binari és el %s en hexadecimal.", binari, hexa);
    }

    public static long binariDecimal(int nbin) {
        int ndec = 0;
        int pot = 1;
        while (nbin != 0) {
            int d = nbin % 10;
            nbin = nbin / 10;
            ndec = (ndec + d * pot);
            pot = pot * 2;
        }
        return ndec;
    }

    public static String digitAHexa(long r) {
        String c;
        if (r >= 0 && r < 10) {
            c = String.valueOf(r);
        } else if (r == 10) {
            c = "A";
        } else if (r == 11) {
            c = "B";
        } else if (r == 12) {
            c = "C";
        } else if (r == 13) {
            c = "D";
        } else if (r == 14) {
            c = "E";
        } else {
            c = "F";
        }
        return c;
    }
}