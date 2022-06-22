package com.biswa.dsa.code.array.day3;

public class SearchSortedMatrix {

    /*
    Write an efficient algorithm that searches for a value target in an m x n integer matrix.
    This matrix has the following properties:
        Integers in each row are sorted from left to right.
        The first integer of each row is greater than the last integer of the previous row.
     */
    public static boolean searchMatrixI(int[][] matrix, int target) {
        int i = 0, j = 0;

        while (i < matrix.length && j < matrix[0].length) {
            if (matrix[i][j] == target)
                return true;

            if (i < matrix.length - 1 && matrix[i+1][j] <= target) i++;
            else if (j < matrix[0].length - 1 && matrix[i][j+1] > target) return false;
            else j++;
        }

        return false;
    }

    public boolean searchMatrixII(int[][] matrix, int target) {
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};

        System.out.println(searchMatrixI(arr, 0));
    }

}
