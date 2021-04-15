package exercise.programmers.monthly.monthly202104;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class q3 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{-5, 0, 2, 1, 2}, new int[][]{{0, 1}, {3, 4}, {2, 3}, {0, 3}}));
    }

    public static long solution(int[] a, int[][] edges) {
        long answer = 0;

        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        if (sum != 0) {
            return -1;
        }

        Graph graph = new Graph(a.length);
        int[] leafArr = new int[a.length];
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            graph.put(x, y);
            leafArr[x]++;
            leafArr[y]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> nodes = graph.getGraph().get(2);
        queue.offer(2);
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            if (isLeaf(cur, leafArr)) {
                for (int i = 0; i < nodes.size(); i++) {
                    Integer adj = nodes.get(i);
                    if (isLeaf(adj, leafArr)) {
                        answer += Math.abs(a[adj]);
                        a[cur] += a[adj];
                        a[adj] = 0;
                    }
                }
            }
        }
        return answer;
    }

    private static boolean isLeaf(Integer cur, int[] leafArr) {
        return leafArr[cur] == 1;
    }

    public static class Graph {

        private ArrayList<ArrayList<Integer>> listGraph;

        public Graph(int initSize) {
            this.listGraph = new ArrayList<>();
            for (int i = 0; i < initSize + 1; i++) {
                listGraph.add(new ArrayList<>());
            }
        }

        public ArrayList<ArrayList<Integer>> getGraph() {
            return this.listGraph;
        }

        public void put(int x, int y) {
            listGraph.get(x).add(y);
            listGraph.get(y).add(x);
        }

        public void printGraphToAdjList() {
            for (int i = 0; i < listGraph.size() - 1; i++) {
                System.out.print("정점 " + i + "의 인접리스트");

                for (int j = 0; j < listGraph.get(i).size(); j++) {
                    System.out.print(" -> " + listGraph.get(i).get(j));
                }
                System.out.println();
            }
        }
    }
}
