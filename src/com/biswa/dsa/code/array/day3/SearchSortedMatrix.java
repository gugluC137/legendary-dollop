package com.biswa.dsa.code.array.day3;

public class SearchSortedMatrix {

    /*
    Write an efficient algorithm that searches for a value target in an m x n integer matrix.
    This matrix has the following properties:
        Integers in each row are sorted from left to right.
        The first integer of each row is greater than the last integer of the previous row.
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;

        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) return true;

            if (matrix[i][j] < target) i++;
            else j--;
        }

        return false;
    }

    /*
    how to realize a 2d matrix as a 1d array
    if index of 1d array is k, then for matrix, row = k/noOfColumns, column = k%noOfColumns
     */
    public static boolean searchMatrixBinarySearch(int[][] matrix, int target) {
        int rows = matrix.length, columns = matrix[0].length;
        int low = 0, high = rows*columns - 1, mid;

        while (low <= high) {
            mid = low + (high - low)/2;
            int val = matrix[mid/columns][mid%columns];

            if (val == target) return true;

            if (val < target) low = mid+1;
            else high = mid-1;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};

        System.out.println(searchMatrix(arr, 0));
    }

}
