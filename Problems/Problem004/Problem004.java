public class Problem004 {
  public static void main(String[] args) {
    int largestPali = 0;
    for(int i = 999; i > 0; i--) {
      if((i * i) < largestPali) {
        break;
      }
      for(int j = i; j > 0; j--) {
        if(i * j < largestPali) {
          break;
        }
        if(isPalindrome(i * j) && (i * j) > largestPali) {
          largestPali = i * j;
          break;
        }
      }
    }
    System.out.println(largestPali);
  }

  public static boolean isPalindrome(int n) {
    return n == reverseNum(n);
  }

  public static int reverseNum(int n) {
    int rev = 0;
    while(n > 0) {
      rev = rev * 10 + (n % 10);
      n /= 10;
    }
    return rev;
  }
}
