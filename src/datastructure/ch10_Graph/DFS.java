package datastructure.ch10_Graph;

import java.util.List;

public class DFS {

    int N; // 그래프 정점의 수
    List<Edge>[] graph;
    private boolean[] visited;

    public DFS(List<Edge>[] adjList) {
        N = adjList.length;
        graph = adjList;
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (!visited[i]) dfs(i);
        }
    }

    // 시간복잡도는 O(N+M), N은 정점의 수, M은 간선의 수
    private void dfs(int i) {
        visited[i] = true;
        System.out.println(i);

        for (Edge e : graph[i]) {
            if (!visited[e.adjVertex]) {
                dfs(e.adjVertex);
            }
        }
    }
}
