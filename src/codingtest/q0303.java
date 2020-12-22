package codingtest;

import java.util.Scanner;

public class q0303 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int result = 0;

        for (int i = 0; i < n; i++) {
            int min_value = 10001;
            for (int j = 0; j < m; j++) {
                int x = sc.nextInt();
                min_value = Math.min(min_value, x);
            }
            result = Math.max(result, min_value);
        }

        System.out.println(result);
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//
//        int[][] cards = new int[n][m];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                cards[i][j] = sc.nextInt();
//            }
//        }
//        System.out.println(Arrays.deepToString(cards));
//
//        List<Integer> candidates = new ArrayList<>();
//        for(int i = 0; i < n; i++) {
//            int smallest = chooseSmallestInRow(cards[i]);
//            candidates.add(smallest);
//        }
//
//        int[] candidatesArray = candidates.stream().mapToInt(i -> i).toArray();
//        Arrays.sort(candidatesArray);
//        System.out.println(candidatesArray[n-1]);
//    }
//
//    private static int chooseSmallestInRow(int[] card) {
//        Arrays.sort(card);
//        return card[0];

//    }
}
