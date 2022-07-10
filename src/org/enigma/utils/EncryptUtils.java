package org.enigma.utils;

import org.enigma.exception.ApplicationException;
import org.enigma.enumerator.ErrorCode;

import static org.enigma.utils.MapUtils.decryptMap;
import static org.enigma.utils.MapUtils.encryptMap;


public class EncryptUtils {

    private EncryptUtils() {}

    public static char encryptChar(char symbol, int securityKey) {
        if (encryptMap.get(symbol) != null) {
            if (Character.isUpperCase(symbol)) {
                int index = encryptMap.get(Character.toLowerCase(symbol));
                int shift = (index + securityKey) % encryptMap.size();
                return Character.toUpperCase(decryptMap.get(shift));
            }
            int index = encryptMap.get(symbol);
            int shift = (index + securityKey) % encryptMap.size();
            return decryptMap.get(shift);
        }
        return symbol;
    }

    public static char decryptChar(char symbol, int securityKey) {
        if (encryptMap.get(symbol) != null) {
            if (Character.isUpperCase(symbol)) {
                int index = encryptMap.get(Character.toLowerCase(symbol));
                int shift = (index + (encryptMap.size() - securityKey)) % encryptMap.size();
                return Character.toUpperCase(decryptMap.get(shift));
            }
            int index = encryptMap.get(symbol);
            int shift = (index + (encryptMap.size() - securityKey)) % encryptMap.size();
            return decryptMap.get(shift);
        }
        throw new ApplicationException("The symbol for decryption is inappropriate", ErrorCode.DECRYPTION_ERROR);
    }

}
