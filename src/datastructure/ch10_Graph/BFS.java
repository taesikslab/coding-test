package datastructure.ch10_Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    int N; // 그래프의 정점의 수
    List<Edge>[] graph;
    private boolean[] visited;

    public BFS(List<Edge>[] adjList) {
        N = adjList.length;
        graph = adjList;
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (!visited[i]) bfs(i);
        }
    }

    private void bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        visited[i] = true;
        q.offer(i);

        while (!q.isEmpty()) {
            int j = q.peek();
            System.out.println(j);
            for (Edge e : graph[j]) {
                if (!visited[e.adjVertex]) {
                    visited[e.adjVertex] = true;
                    q.offer(e.adjVertex);
                }
            }
        }
    }
}
