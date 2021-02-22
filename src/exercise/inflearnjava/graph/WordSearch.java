package exercise.inflearnjava.graph;

public class WordSearch {

    private static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int m, n;

    public static void main(String[] args) {
        char[][] grid = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "BCX";
        System.out.println(solve(grid, word));
    }

    public static boolean solve(char[][] grid, String word) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return false;

        m = grid.length;
        n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(grid, visited, i, j, 0, word))
                    return true;
            }
        }

        return false;
    }

    private static boolean dfs(char[][] grid, boolean[][] visited, int i, int j, int start, String word) {
        print(visited);
        if (start == word.length()) return true;
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        if (visited[i][j]) return false;
        if (grid[i][j] != word.charAt(start)) return false;

        visited[i][j] = true;

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (dfs(grid, visited, x, y, start + 1, word)) {
                return true;
            }
        }

        visited[i][j] = false;

        return false;
    }

    private static void print(boolean[][] visited) {
        if (visited == null || visited.length == 0) return;

        int m = visited.length, n = visited[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(visited[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("====================================");
    }
}
