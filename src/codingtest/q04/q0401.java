package codingtest.q04;

import java.util.Scanner;

public class q0401 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String[] plans = sc.nextLine().split(" ");

        int x = 1;
        int y = 1;

        for (String plan : plans) {
            switch (plan) {
                case "L":
                    if (y == 1) break;
                    y -= 1;
                    break;
                case "R":
                    if (y == n) break;
                    y += 1;
                    break;
                case "U":
                    if (x == 1) break;
                    x -= 1;
                    break;
                case "D":
                    if (x == n) break;
                    x += 1;
                    break;
            }
        }

        System.out.println(x + " " + y);

    }
}
