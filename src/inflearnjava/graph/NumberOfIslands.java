package inflearnjava.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    private static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        char[][] grid1 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        char[][] grid3 = {
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'}
        };
        char[][] grid4 = {
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'}
        };

        System.out.println(numsIslands_dfs(grid1));
        System.out.println("==================================================================================");
        System.out.println(numsIslands_bfs(grid2));
        System.out.println("==================================================================================");
        System.out.println(numsIslands_dfs(grid3));
        System.out.println("==================================================================================");
        System.out.println(numsIslands_bfs(grid4));
    }

    public static int numsIslands_dfs(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    System.out.println("i=" + i + ", j=" + j);
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') return;
        grid[i][j] = 'X';
        print(grid);

        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    public static void print(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int numsIslands_bfs(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.println("i=" + i + ", j=" + j);
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private static void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        grid[i][j] ='0';

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int[] dir : dirs) {
                int x1 = point[0] + dir[0];
                int y1 = point[1] + dir[1];
                if (x1 >= 0 && y1 >= 0 && x1 < grid.length && y1 < grid[0].length && grid[x1][y1] == '1') {
                    grid[x1][y1] = '0';
                    queue.offer(new int[]{x1, y1});
                    print(grid);
                }
            }
        }
    }
}
