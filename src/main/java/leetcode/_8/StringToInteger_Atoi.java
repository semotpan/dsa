package leetcode._8;

public class StringToInteger_Atoi {

    public int myAtoi(String input) {
        var length = input.length();
        var result = 0;
        var sign = true;
        int index = 0;

        // 1 read (leading chars)spaces
        while (index < length && input.charAt(index) == ' ') {
            index++;
        }

        if (index == length) {
            return 0;
        }

        // 2 read sign
        if (input.charAt(index) == '-' || input.charAt(index) == '+') {
            if (input.charAt(index) == '-') {
                sign = false;
            }
            index++;
        }

        var bound = Integer.MAX_VALUE / 10;
        var boundChange = Integer.MAX_VALUE % 10;

        // read digits,if non digit ignore
        while (index < length && Character.isDigit(input.charAt(index))) {
            int digit = input.charAt(index) - '0';

            // check overflow
            if (result > bound || (result == bound && digit > boundChange)) {
                return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        return sign ? result : (result * -1);
    }
}
