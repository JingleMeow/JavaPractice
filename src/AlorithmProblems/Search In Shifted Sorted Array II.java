//Search In Shifted Sorted Array II
//  Given a target integer T and an integer array A, A is sorted in ascending order first, then shifted by an arbitrary number of positions.
//
//  For Example, A = {3, 4, 5, 1, 2} (shifted left by 2 positions). Find the index i such that A[i] == T or return -1 if there is no such index.
//
//  Assumptions
//  There could be duplicate elements in the array.
//  Return the smallest index if target has multiple occurrence.
//
//  Examples
//  A = {3, 4, 5, 1, 2}, T = 4, return 1
//  A = {3, 3, 3, 1, 3}, T = 1, return 3
//  A = {3, 1, 3, 3, 3}, T = 1, return 1
//
//  Corner Cases
//  What if A is null or A is of zero length? We should return -1 in this case.


public class Solution {
    public int search(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            // Always check left first or you have to check it later anyway
            if (array[left] == target)
                return left;
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                right = mid;
                continue;
            }

            if (array[left] == array[mid] && array[mid] == array[right]) {
                left++;
                right--;
                continue;
            }

            if (array[left] <= array[mid]) {
                if (array[left] <= target && target < array[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                if (array[mid] < target && target <= array[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return array[left] == target ? left : -1;
    }
}
