package org.enigma.utils;

import static org.enigma.utils.MapUtils.decryptMap;
import static org.enigma.utils.MapUtils.encryptMap;


public class EncryptUtils {

    private EncryptUtils() {}

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

}
