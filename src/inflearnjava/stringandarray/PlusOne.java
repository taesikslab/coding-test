package inflearnjava.stringandarray;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
        PlusOne problem = new PlusOne();
        System.out.println(Arrays.toString(problem.plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(problem.plusOne(new int[]{9, 9, 9})));
        System.out.println(Arrays.toString(problem.plusOne(new int[]{8, 9, 9})));
        System.out.println(Arrays.toString(problem.plusOne(new int[]{8, 9, 8})));
        System.out.println(Arrays.toString(problem.plusOne(new int[]{8, 8, 9})));
    }

    public int[] plusOne(int[] digits) {
        // 1. data structure
        int index = digits.length - 1;
        int carry = 1;

        // 2. for, while
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
