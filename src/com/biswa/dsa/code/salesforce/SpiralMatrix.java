package com.biswa.dsa.code.salesforce;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int rows = matrix.length;
        int columns = matrix[0].length;

        int top = 0, bottom = rows - 1;
        int left = 0, right = columns - 1;

        while (top <= bottom && left <= right) {

            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;
            if (top > bottom) break;

            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            if (left > right) break;

            for (int i = right; i >= left; i--) {
                ans.add(matrix[bottom][i]);
            }
            bottom--;
            if (top > bottom) break;

            for (int i = bottom; i >= top; i--) {
                ans.add(matrix[i][left]);
            }
            left++;
        }

        return ans;

    }

    public static void main(String[] args) {
        int[][] matrix1 = {
                {1,2,3,4,5},
                {18,19,20,21,6},
                {17,28,29,22,7},
                {16,27,30,23,8},
                {15,26,25,24,9},
                {14,13,12,11,10}
        };

        int[][] matrix2 = {
                {1,2,3,4},
                {10,11,12,5},
                {9,8,7,6}
        };

        System.out.println(new SpiralMatrix().spiralOrder(matrix2));

        //new SpiralMatrix().spiralMatrixPrint(matrix2);

    }
}
