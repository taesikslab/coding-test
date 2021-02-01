package inflearnjava.graph;

public class MaxOfIsland {

    private static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int m;
    private static int n;

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 1, 1},
                        {0, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0},
                        {1, 1, 0, 1, 1},
                        {1, 0, 1, 1, 1},
                        {1, 0, 1, 1, 1}};

        System.out.println(maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        m = grid.length;
        n = grid[0].length;
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, 0);
                    System.out.println(size);
                    max = Math.max(max, size);
                }
            }
        }

        return max;
    }

    private static int dfs(int[][] grid, int x, int y, int size) {
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0) return size;

        grid[x][y] = 0;
        size++;
        for (int[] dir : dirs) {
            size = dfs(grid, x + dir[0], y + dir[1], size);
        }

        return size;
    }
}
