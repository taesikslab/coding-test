package exercise.inflearnjava.graph;

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

    private static int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        m = grid.length;
        n = grid[0].length;
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = 0;
                    area = dfs(i, j, grid, area);
                    max = Math.max(max, area);
                }
            }
        }

        return max;
    }

    private static int dfs(int i, int j, int[][] grid, int area) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1)
            return 0;

        area++;
        grid[i][j] = 0;

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            area = Math.max(area, dfs(x, y, grid, area));
        }

        return area;
    }
}
