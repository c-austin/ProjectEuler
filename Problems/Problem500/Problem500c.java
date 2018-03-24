import java.util.*;

public class Problem500 {
  public static void main(String[] args) {
    int[] primes  = primeSieve(7500000);
    SortedSet<Long> nums = new TreeSet<Long>();
    for(int k : primes) {
      nums.add((long) k);
    }
    long product = 1L;
    long temp = 0L;

    for(int i = 0; i < 500500; i++) {
      temp = nums.first();
      nums.remove(temp);
      product *= temp;
      product %= 500500507;
      temp *= temp;
      nums.add(temp);
    }
    System.out.println(product);
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
