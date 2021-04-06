// Determine If One String Is Another's Substring

// Determine if a small string is a substring of another large string.
// Return the index of the first occurrence of the small string in the large string.
// Return -1 if the small string is not a substring of the large string.

// Assumptions
// Both large and small are not null
// If small is empty string, return 0

// Examples
// “ab” is a substring of “bcabc”, return 2
// “bcd” is not a substring of “bcabc”, return -1
// "" is substring of "abc", return 0

public class Solution {
  private static final int smPrime = 31;
  private static final int lgPrime = 101;

  public int strstr(String large, String small) {
    if (small.length() == 0)
      return 0;
    if (small.length() > large.length())
      return -1;
    
    int seed = 1, smHash = 0, lgHash = 0;
    for (int i = 0; i < small.length() - 1; i++) {
      seed = nextHash(seed, 0, 0, 0);
      smHash = nextHash(smHash, 0, 0, small.charAt(i));
      lgHash = nextHash(lgHash, 0, 0, large.charAt(i));
    }
    smHash = nextHash(smHash, 0, 0, small.charAt(small.length() - 1));
    
    int lgOut = 0;
    for (int i = small.length() - 1; i < large.length(); i++) {
      lgHash = nextHash(lgHash, seed, lgOut, large.charAt(i));
      int startPos = i - small.length() + 1;
      if (lgHash == smHash && equals(large, small, startPos))
        return startPos;
      lgOut = large.charAt(startPos);
    }
    
    return -1;
  }

  private int nextHash(int hash, int seed, int out, int in) {
    hash = (hash - seed * out % lgPrime) % lgPrime;
    if (hash < 0)
      hash += lgPrime;
    return (hash * smPrime % lgPrime + in % lgPrime) % lgPrime;
  }

  private boolean equals(String large, String small, int start) {
    int end = start + small.length() - 1;
    if (end >= large.length())
      return false;
    for (int i = start; i <= end; i++) {
      if (large.charAt(i) != small.charAt(i - start))
        return false;
    }
    return true;
  }
}
