// Determine if there exists a set of four elements in a given array that sum to the given target number.
//
// Assumptions//
// The given array is not null and has length of at least 4
//
// Examples
// A = {1, 2, 2, 3, 4}, target = 9, return true(1 + 2 + 2 + 4 = 9)
// A = {1, 2, 2, 3, 4}, target = 12, return false

public class Solution {
  public boolean exist(int[] array, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 1; i < array.length; i++) {
      for (int j = 0; j < i; j++) {
        int sum = array[i] + array[j];
        Integer partner = map.get(target - sum);
        // make sure the partner's larger index is less than current smaller index
        if (partner != null && partner < j)
          return true;
        
        Integer peer = map.get(sum);
        if (peer == null)
          map.put(sum, i);
      }
    }
    return false;
  }
}
