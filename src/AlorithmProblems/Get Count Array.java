// Given an array A of length N containing all positive integers from [1...N]. How to get an array B such that B[i] represents how many elements A[j] (j > i) in array A that are smaller than A[i].
//
// Assumptions:
// The given array A is not null.
//
// Examples:
// A = { 4, 1, 3, 2 }, we should get B = { 3, 0, 1, 0 }.
//
// Requirement:
// time complexity = O(nlogn).

public class Solution {
  public int[] countArray(int[] array) {
    int[] indexArray = initIndexArray(array);
    int[] B = new int[array.length];
    mergeSort(array, new int[array.length], B, indexArray, 0, array.length - 1);
    return B;
  }

  private int[] initIndexArray(int[] array) {
    int[] indice = new int[array.length];
    for (int i = 0; i < array.length; i++)
      indice[i] = i;
    return indice;
  }

  private void mergeSort(int[] A, int[] helper, int[] B, int[] indexArray, int start, int end) {
    if (end <= start)
      return;
    
    int mid = start + (end - start) / 2;
    mergeSort(A, helper, B, indexArray, start, mid);
    mergeSort(A, helper, B, indexArray, mid + 1, end);
    
    copyArray(indexArray, helper, start, end);

    int ai = start, bi = mid + 1;
    int p = start;
    while (ai <= mid) {
      if (bi > end || A[helper[ai]] <= A[helper[bi]]) {
        indexArray[p++] = helper[ai];
        B[helper[ai++]] += bi - mid - 1;
      } else {
        indexArray[p++] = helper[bi++];
      }
    }
  }

  private void copyArray(int[] array, int[] helper, int start, int end) {
    for (int i = start; i <= end; i++)
      helper[i] = array[i];
  }
}
