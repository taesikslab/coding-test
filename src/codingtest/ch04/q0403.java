package codingtest.ch04;

import java.util.Scanner;

public class q0403 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String position = sc.nextLine();
        System.out.println(position);

        int x = position.charAt(0);
        int y = Character.getNumericValue(position.charAt(1));
        System.out.println("x = " + x +  ", y = " + y); // a = 97

        final int XMIN = 97;
        final int XMAX = 104;
        final int YMIN = 1;
        final int YMAX = 8;

        int answer = 0;
        if ((x-2) >= XMIN) {
            if ((y-1) >= YMIN) answer++;
            if ((y+1) <= YMAX) answer++;
        }
        if ((x+2) <= XMAX) {
            if ((y-1) >= YMIN) answer++;
            if ((y+1) <= YMAX) answer++;
        }
        if ((y-2) >= YMIN) {
            if ((x-1) >= XMIN) answer++;
            if ((x+1) <= XMAX) answer++;
        }
        if ((y+2) <= YMAX) {
            if ((x-1) >= XMIN) answer++;
            if ((x+1) <= XMAX) answer++;
        }
        System.out.println(answer);
    }
}
