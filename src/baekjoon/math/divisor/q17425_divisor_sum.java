package baekjoon.math.divisor;

import java.io.*;

public class q17425_divisor_sum {
    static final int MAX = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] d = new long[MAX + 1];
        for (int i = 1; i <= MAX; i++) {
            d[i] = 1;
        }
        for (int i = 2; i <= MAX; i++) {
            for (int j = 1; i * j <= MAX; j++) {
                d[i * j] += i;
            }
        }

        long[] sum = new long[MAX + 1];
        for (int i = 1; i <= MAX; i++) {
            sum[i] = sum[i - 1] + d[i];
        }

        int t = Integer.parseInt(bf.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(bf.readLine());
            bw.write(sum[n] + "\n");
        }
        bw.flush();
    }
}
