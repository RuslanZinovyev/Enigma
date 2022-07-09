package org.enigma;

import java.util.HashMap;
import java.util.Map;

public class MapUtils {

    private MapUtils() {
    }

    public static final Map<Character, Integer> encryptMap = new HashMap<>();
    public static final Map<Integer, Character> decryptMap = new HashMap<>();

    static {
        encryptMap.put('а', 1);
        encryptMap.put('б', 2);
        encryptMap.put('в', 3);
        encryptMap.put('г', 4);
        encryptMap.put('д', 5);
        encryptMap.put('е', 6);
        encryptMap.put('ё', 7);
        encryptMap.put('ж', 8);
        encryptMap.put('з', 9);
        encryptMap.put('и', 10);
        encryptMap.put('й', 11);
        encryptMap.put('к', 12);
        encryptMap.put('л', 13);
        encryptMap.put('м', 14);
        encryptMap.put('н', 15);
        encryptMap.put('о', 16);
        encryptMap.put('п', 17);
        encryptMap.put('р', 18);
        encryptMap.put('с', 19);
        encryptMap.put('т', 20);
        encryptMap.put('у', 21);
        encryptMap.put('ф', 22);
        encryptMap.put('х', 23);
        encryptMap.put('ц', 24);
        encryptMap.put('ч', 25);
        encryptMap.put('ш', 26);
        encryptMap.put('щ', 27);
        encryptMap.put('ъ', 28);
        encryptMap.put('ы', 29);
        encryptMap.put('ь', 30);
        encryptMap.put('э', 31);
        encryptMap.put('ю', 32);
        encryptMap.put('я', 33);

        decryptMap.put(1, 'а');
        decryptMap.put(2, 'б');
        decryptMap.put(3, 'в');
        decryptMap.put(4, 'г');
        decryptMap.put(5, 'д');
        decryptMap.put(6, 'е');
        decryptMap.put(7, 'ё');
        decryptMap.put(8, 'ж');
        decryptMap.put(9, 'з');
        decryptMap.put(10, 'и');
        decryptMap.put(11, 'й');
        decryptMap.put(12, 'к');
        decryptMap.put(13, 'л');
        decryptMap.put(14, 'м');
        decryptMap.put(15, 'н');
        decryptMap.put(16, 'о');
        decryptMap.put(17, 'п');
        decryptMap.put(18, 'р');
        decryptMap.put(19, 'с');
        decryptMap.put(20, 'т');
        decryptMap.put(21, 'у');
        decryptMap.put(22, 'ф');
        decryptMap.put(23, 'х');
        decryptMap.put(24, 'ц');
        decryptMap.put(25, 'ч');
        decryptMap.put(26, 'ш');
        decryptMap.put(27, 'щ');
        decryptMap.put(28, 'ъ');
        decryptMap.put(29, 'ы');
        decryptMap.put(30, 'ь');
        decryptMap.put(31, 'э');
        decryptMap.put(32, 'ю');
        decryptMap.put(33, 'я');
    }
}
