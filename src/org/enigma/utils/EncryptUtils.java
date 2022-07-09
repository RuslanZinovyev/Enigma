package org.enigma.utils;

import java.util.Locale;
import static org.enigma.utils.MapUtils.*;


public class EncryptUtils {

    private EncryptUtils() {}

    public static  String name = "диана";
    public static  String nameDec = "гзямя";

    //TODO this method should be fixed, need to address capital letter
    public static char encryptChar(char symbol, int securityKey) {
        int index = encryptMap.get(symbol);
        int shift = (index + securityKey) % encryptMap.size();
        return decryptMap.get(shift);
    }

    public static char decryptChar(char symbol, int securityKey) {
        int index = encryptMap.get(symbol);
        int shift = (index + (encryptMap.size() - securityKey)) % encryptMap.size();
        return decryptMap.get(shift);
    }


    public static void main(String[] args) {
        for (char s : nameDec.toLowerCase(Locale.ROOT).toCharArray()) {
            System.out.print(decryptChar(s, 32));
        }
    }
}
