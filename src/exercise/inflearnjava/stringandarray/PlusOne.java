package exercise.inflearnjava.stringandarray;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{8, 9, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{8, 9, 8})));
        System.out.println(Arrays.toString(plusOne(new int[]{8, 8, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{1, 9, 9})));
    }

    public static int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        int carry = 1;

        while (index >= 0 && carry > 0) {
            digits[index] = (digits[index] + 1) % 10;

            if (digits[index] == 0) {
                carry = 1;
            } else {
                carry = 0;
            }

            index--;
        }

        if (carry == 1) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }

        return digits;
    }
}
