package codingtest.q04;

import java.util.Scanner;

public class q0402 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int count = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= 59; j++) {
                for (int k = 0; k <= 59; k++) {
                    String hour = String.valueOf(i);
                    String min = String.valueOf(j);
                    String sec = String.valueOf(k);
                    if(hour.contains("3") || min.contains("3") || sec.contains("3")) count++;
                    // String time = hour + min + sec; time.contains("3)
                }
            }
        }

        System.out.println(count);
    }
}
