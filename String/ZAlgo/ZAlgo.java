public class ZAlgo {
  public int[] getZArr(String A) {
    int[] zArr = new int[A.length()];
    int left = 0, right = 0, prev = 0;
    zArr[0] = A.length();
    for (int index = 1; index < A.length(); index++) {
      if (index > right) { // not in window
        left = index;
        right = index;
        while (right < A.length() && (A.charAt(right - left) == A.charAt(right))) {
          ++right;
        }
        zArr[index] = right - left;
        --right;
      } else { // in window
        prev = index - left;
        if (zArr[prev] < (right - index - 1)) { // in window
          zArr[index] = zArr[prev];
        } else { // nit in window
          left = index;
          while (right < A.length() && (A.charAt(right - left) == A.charAt(right))) {
            ++right;
          }
          zArr[index] = right - left;
          --right;
        }
      }
    }
    return zArr;
  }
}