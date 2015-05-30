import org.jetbrains.annotations.Contract;

import java.util.HashMap;

class Converter {

    private final HashMap<Character, Integer> charToInt = new HashMap<>();
    private final HashMap<Integer, Character> intToChar = new HashMap<>();

    public Converter() {
        charToInt.put('0', 0);
        charToInt.put('1', 1);
        charToInt.put('2', 2);
        charToInt.put('3', 3);
        charToInt.put('4', 4);
        charToInt.put('5', 5);
        charToInt.put('6', 6);
        charToInt.put('7', 7);
        charToInt.put('8', 8);
        charToInt.put('9', 9);
        intToChar.put(0, '0');
        intToChar.put(1, '1');
        intToChar.put(2, '2');
        intToChar.put(3, '3');
        intToChar.put(4, '4');
        intToChar.put(5, '5');
        intToChar.put(6, '6');
        intToChar.put(7, '7');
        intToChar.put(8, '8');
        intToChar.put(9, '9');
    }

    @Contract("null -> null")
    public int stringToInt(String s) {
        if (s == null || s.length() == 0) {
            throw new RuntimeException();
        }
        int length = s.length();
        boolean negative = false;
        if (s.charAt(0) == '-') {
            negative = true;
            length -= 1;
        }
        int output = 0;
        for (int i = 0; i < length; i++) {
            output += (int) (Math.pow(10, i)) * charToInt.get(s.charAt(s.length() - i - 1));
        }
        return negative ? -output : output;
    }

    public String intToString(Integer i) {
        if (i == 0) {
            return "0";
        }
        Integer j = i;
        StringBuilder output = new StringBuilder();
        boolean negative = j < 0;
        if (negative) {
            j = -j;
        }
        while (j > 0) {
            output.append(intToChar.get(j % 10));
            j /= 10;
        }
        if (negative) {
            output.append('-');
        }
        return output.reverse().toString();
    }

}
