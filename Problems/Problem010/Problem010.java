import java.util.*;

public class Problem010 {
  public static void main(String[] args) {

    int target = 2000000;

    int[] list = primeSieve(target);
    long sum = 0L;
    for(int k : list) {
      sum += k;
    }

    System.out.println(sum);
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
