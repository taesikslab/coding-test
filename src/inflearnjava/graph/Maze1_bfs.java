package inflearnjava.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Maze1_bfs {

    private static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int m, n;

    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        int[] start = {0, 4};
        int[] dest = {4, 2};
        System.out.println(hasPath(maze, start, dest));
    }

    private static boolean hasPath(int[][] maze, int[] start, int[] dest) {
        m = maze.length;
        n = maze[0].length;

        if (start[0] == dest[0] && start[1] == dest[1]) return true;

        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1]});

        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int[] dir : dirs) {
                int x = p[0] + dir[0];
                int y = p[1] + dir[1];
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }
                x -= dir[0];
                y -= dir[1];
                if (visited[x][y] == true) continue;
                visited[x][y] = true;
                if (x == dest[0] && y == dest[1]) return true;
                queue.offer(new int[]{x, y});
                print(visited);
            }
        }

        return false;
    }

    private static void print(boolean[][] visited) {
        if (visited == null || visited.length == 0)
            return;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(visited[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
