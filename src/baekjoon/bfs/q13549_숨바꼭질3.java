package baekjoon.bfs;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q13549_숨바꼭질3 {


    public static final int MAX = 1000000;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] c = new boolean[MAX];
        int[] d = new int[MAX];
        c[n] = true;
        d[n] = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        Queue<Integer> next_queue = new LinkedList<Integer>();
        q.add(n);
        while (!q.isEmpty()) {
            int now = q.remove();
            for (int next : new int[]{now * 2, now - 1, now + 1}) {
                if (next >= 0 && next < MAX) {
                    if (c[next] == false) {
                        c[next] = true;
                        if (now * 2 == next) {
                            q.add(next);
                            d[next] = d[now];
                        } else {
                            next_queue.add(next);
                            d[next] = d[now] + 1;
                        }
                    }
                }
            }
            if (q.isEmpty()) {
                q = next_queue;
                next_queue = new LinkedList<Integer>();
            }
        }
        System.out.println(d[m]);
    }

    public static void deque(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] c = new boolean[MAX];
        int[] d = new int[MAX];
        c[n] = true;
        d[n] = 0;
        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        q.add(n);
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : new int[]{now * 2, now - 1, now + 1}) {
                if (next >= 0 && next < MAX) {
                    if (c[next] == false) {
                        c[next] = true;
                        if (next == now * 2) {
                            q.addFirst(next);
                            d[next] = d[now];
                        } else {
                            q.addLast(next);
                            d[next] = d[now] + 1;
                        }
                    }
                }
            }
        }
        System.out.println(d[m]);
    }
}
