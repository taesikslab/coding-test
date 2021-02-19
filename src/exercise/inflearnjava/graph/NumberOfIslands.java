package exercise.inflearnjava.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    private static final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

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
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    answer++;
                    dfs(i, j, grid);
                    print(grid);
                }
            }
        }

        return answer;
    }

    private static void dfs(int i, int j, char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (i >= m || i < 0 || j >= n || j < 0 || grid[i][j] != '1')
            return;

        grid[i][j] = 'X';
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            dfs(x, y, grid);
        }
    }

    public static int numsIslands_bfs(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    answer++;
                    bfs(i, j, grid);
                }
            }
        }

        return answer;
    }

    private static void bfs(int i, int j, char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        grid[i][j] = '0';

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int[] dir : dirs) {
                int x = point[0] + dir[0];
                int y = point[1] + dir[1];

                if (x < m && x >= 0 && y < n && y >= 0 && grid[x][y] == '1') {
                    grid[x][y] = '0';
                    queue.offer(new int[]{x, y});
                }
            }
        }
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
}
