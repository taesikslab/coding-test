package baekjoon.dynamic_programming;

public class fibonacci {

    int[] memo = new int[100];

    int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            if (memo[n] > 0) {
                return memo[n];
            }
            memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
            return memo[n];
        }
    }
}
