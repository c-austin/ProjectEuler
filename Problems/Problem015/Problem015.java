public class Problem015 {
  public static void main(String[] args) {
  long test = choose(40,20);
  System.out.println(test);
  }

  public static long choose(int n, int k) {
    int[] primeFactors = primeSieve(n);

    int[] noname = new int[primeFactors.length];

    int q = 0;
    int index = 0;

    for(int i = n; i > n - k; i--) {
      q = i;
      index = 0;
      while(q > 1) {
        while(q % primeFactors[index] == 0) {
          noname[index]++;
          q /= primeFactors[index];
        }
        index++;
      }
    }

    for(int i = 1; i <= k; i++) {
      q = i;
      index = 0;
      while(q > 1) {
        while(q % primeFactors[index] == 0) {
          noname[index]--;
          q /= primeFactors[index];
        }
        index++;
      }
    }

    long product = 1L;

    for(int i = 0; i < noname.length; i++) {
      while(noname[i] > 0) {
        product *= primeFactors[i];
        noname[i]--;
      }
    }

    return product;



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
