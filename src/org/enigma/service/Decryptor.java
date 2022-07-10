package org.enigma.service;

import org.enigma.enumerator.ErrorCode;
import org.enigma.exception.ApplicationException;

import static org.enigma.utils.MapUtils.decryptMap;
import static org.enigma.utils.MapUtils.encryptMap;

public class Decryptor implements Operation {
    private int securityKey;

    public Decryptor(int securityKey) {
        this.securityKey = securityKey;
    }

    @Override
    public char execute(char symbol) {
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
