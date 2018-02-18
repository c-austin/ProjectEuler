public class Problem038 {
  public static void main(String[] args) {
    long max = 0L;

    for(int i = 1; i < 10000; i++) {
      long q = makeChain(i);
      if(isPanDigital(q) && q > max) {
        max = q;
      }
    }

    System.out.println(max);

  }

  public static long makeChain(int n) {
    int i = 1;
    long a = 0L;
    long b = 0L;

    while(distinctDigits(a)) {
      b = a;
      a = concatenate(a,n*i);
      i++;
    }
    return b;
  }

  public static boolean distinctDigits(long n) {
    int[] digits = new int[10];
    while(n > 0) {
      int dig = (int) (n % 10);
      digits[dig]++;
      if(digits[dig] > 1) {
        return false;
      } else {
        n /= 10;
      }
    }
    return true;
  }

  public static long concatenate(long m, long n) {
    long copy = n;
    while(copy > 0) {
      m *= 10;
      copy /= 10;
    }
    return m + n;
  }

  public static boolean isPanDigital(long n) {
    int[] digits = new int[10];
    int sum = 0;
    while(n > 0) {
      int digit = (int) (n % 10);
      if(digit == 0) {
        return false;
      }
      if(digits[digit] > 0) {
        return false;
      }
      digits[digit]++;
      sum++;
      n /= 10;
    }
    return sum == 9;
  }
}
