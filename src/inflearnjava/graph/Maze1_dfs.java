package inflearnjava.graph;

public class Maze1_dfs {

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
        int[] dest = {4, 4};
        System.out.println(hasPath(maze, start, dest));
    }

    private static boolean hasPath(int[][] maze, int[] start, int[] dest) {
        if (maze == null || maze.length == 0) return false;
        m = maze.length;
        n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(maze, start, dest, visited);
    }

    private static boolean dfs(int[][] maze, int[] start, int[] dest, boolean[][] visited) {
        if (start[0] < 0 || start[0] >= m || start[1] < 0 || start[1] >= n || visited[start[0]][start[1]]) return false;

        visited[start[0]][start[1]] = true;
        if (start[0] == dest[0] && start[1] == dest[1]) return true;

        for (int[] dir : dirs) {
            int x = start[0];
            int y = start[1];
            while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] != 1) {
                x += dir[0];
                y += dir[1];
            }
            x -= dir[0];
            y -= dir[1];
            print(visited);
            if (dfs(maze, new int[]{x, y}, dest, visited)) return true;
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
