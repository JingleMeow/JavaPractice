// Given an array with both positive and negative numbers in random order. Shuffle the array so that positive and negative numbers are put in position with even and odd indices, respectively.
// If there are more positive/negative numbers, put them at the end of the array. The ordering of positive/negative numbers does not matter.

// Assumptions:
// The given array is not null.
// There is no 0 in the array.

// Examples:
// {1, 2, 3, 4, 5, -1, -1, -1} --> {1, -1, 2, -1, 3, -1, 4, 5} (The ordering of positive/negative numbers do not matter)

public class Solution {
  public int[] interleave(int[] array) {
    if (array == null || array.length == 0)
      return array;
    
    // [...i): neg
    // (j...]: pos
    int i = 0, j = array.length - 1;
    while (i <= j) {
      if (array[i] < 0)
        i++;
      else
        swap(array, i, j--);
    }

    int neg = 0, pos = i;
    while (neg < pos && pos < array.length) {
      swap(array, neg, pos);
      neg += 2;
      pos++;
    }
    return array;
  }

  private void swap(int[] array, int a, int b) {
    int tmp = array[a];
    array[a] = array[b];
    array[b] = tmp;
  }
}
