import java.util.*;

public class SpiralOrderRunner {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        Solution solution = new Solution();
        List<Integer> result = solution.spiralOrder(matrix);

        System.out.println("Spiral order traversal: " + result);
    }
}

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int dir = 0, top = 0, left = 0, bottom = matrix.length - 1, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Moving left to right
            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    list.add(matrix[top][i]);
                }
                top++; // move the top boundary down
                dir = 1;
            }
            // Moving top to bottom
            else if (dir == 1) {
                for (int i = top; i <= bottom; i++) {
                    list.add(matrix[i][right]);
                }
                right--; // move the right boundary left
                dir = 2;
            }
            // Moving right to left
            else if (dir == 2) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--; // move the bottom boundary up
                dir = 3;
            }
            // Moving bottom to top
            else if (dir == 3) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++; // move the left boundary right
                dir = 0; // reset the direction to start again
            }
        }

        return list;
    }
}
