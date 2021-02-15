package exercise.inflearnjava.stringandarray;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    private static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println(solve(matrix));
        int[][] matrix2 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}};
        System.out.println(solve(matrix2));
    }

    public static List<Integer> solve(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return answer;

        int rowStart = 0;
        int rowEnd = matrix.length - 1;

        int colStart = 0;
        int colEnd = matrix[0].length - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // right
            for (int i = colStart; i <= colEnd; i++) {
                answer.add(matrix[rowStart][i]);
            }
            rowStart++;

            // down
            for (int i = rowStart; i <= rowEnd; i++) {
                answer.add(matrix[i][colEnd]);
            }
            colEnd--;

            // left
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    answer.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;
            
            // up
            if (colStart <= colEnd) {
                if (rowStart <= rowEnd) {
                    for (int i = rowEnd; i >= rowStart; i--) {
                        answer.add(matrix[i][colStart]);
                    }
                }
            }
            colStart++;
        }
        
        return answer;
    }
}