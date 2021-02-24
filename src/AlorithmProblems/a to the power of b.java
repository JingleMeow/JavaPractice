// Evaluate a to the power of b, assuming both a and b are integers and b is non-negative.

// Examples
// power(2, 0) = 1
// power(2, 3) = 8
// power(0, 10) = 0
// power(-2, 5) = -32

// Corner Cases
// In this question, we assume 0^0 = 1.
// What if the result is overflowed? We can assume the result will not be overflowed when we solve this problem on this online judge.

public class Solution {
  public long power(int a, int b) {    
    long result = 1;
    while (b > 0) {
      if (b % 2 == 0) {
        a = a * a;
        b /= 2;
      } else {
        result *= a;
        b--;
      }
    }
    return result;
  }
}
