public class Problem012 {
  public static void main(String[] args) {
    int searchLim = 100000;
    int divisorTarget = 500;

    int[] possibleFactors = primeSieve(searchLim / 2);

    int a = 0;
    int b = 0;

    for(int i = 3; i < searchLim; i += 2) {
      a = numberOfDivisors(i,possibleFactors);
      b = numberOfDivisors(i / 2, possibleFactors);
      if(a * b > divisorTarget) {
        System.out.println(i * (i / 2));
        break;
      }
      b = numberOfDivisors((i + 1) / 2, possibleFactors);
      if(a * b > divisorTarget) {
        System.out.println(((i + 1) / 2) * i);
        break;
      }
    }
  }


  public static int numberOfDivisors(int n, int[] possibleFactors) {
    int numOfFacts = 1;
    for(int i = 0; i < possibleFactors.length; i++) {
      if(possibleFactors[i] > n) {
        break;
      }
      int temp = 1;
      while(n % possibleFactors[i] == 0) {
        temp++;
        n /= possibleFactors[i];
      }
      numOfFacts *= (temp);
    }
    return numOfFacts;
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
