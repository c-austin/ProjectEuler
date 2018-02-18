public class Problem026 {
  public static void main(String[] args) {
    int[] primes = primeSieve(1000);
    int maxLen = 0;
    int maxTerm = 0;
    for(int k : primes) {
      int temp = periodCalc(k);
      if(temp > maxLen) {
        maxLen = temp;
        maxTerm = k;
      }
    }
    System.out.println(maxTerm);
  }

  public static int periodCalc(int n) {
    int len = 0;
    boolean[] rems = new boolean[n];
    int quotient = 1;
    int remainder = 0;

    while(true) {
      remainder = quotient % n;
      quotient = 10 * remainder;
      if(rems[remainder]) {
        break;
      }
      rems[remainder] = true;
      len++;
    }

    return len;
  }

  public static int[] primeSieve(int n) {
    boolean[] isPrime = new boolean[n + 1];

    isPrime[2] = true;

    for(int i = 3; i <= n; i++) {
      if(i % 2 != 0) {
        isPrime[i] = true;
      }
    }

    int count = 1;

    for(int i = 3; i <= n; i += 2) {
      if(isPrime[i]) {
        count++;
        for(int j = 2; j * i <= n; j++) {
          isPrime[i * j] = false;
        }
      }
    }

    int[] primes = new int[count];
    int index = 0;

    for(int i = 2; i <= n; i++) {
      if(isPrime[i]) {
        primes[index] = i;
        index++;
      }
    }
    return primes;
  }
}
