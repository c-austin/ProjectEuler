public class Problem014 {
  public static final int limit = 1000000;
  public static int[] chains = new int[limit + 1];
  public static int maxStart = 0;
  public static int maxTerms = 0;

  public static void main(String[] args) {
    for(int i = 2; i < limit; i++) {
      chainMaker(i);
    }
    System.out.println(maxStart + "\t" + maxTerms);
  }

  public static void chainMaker(int k) {
    int count = 1;
    long n = k;
    while(n > 1) {
      if(n % 2 == 0) {
        n /= 2;
      } else {
        n = 3 * n + 1;
      }
      if(n < limit) {
        if(chains[(int) n] != 0) {
          chains[k] = chains[(int) n] + count;
          break;
        }
      }
      count++;
    }

    if(n == 1) {
      chains[k] = count;
    }

    if(chains[k] > maxTerms) {
      maxTerms = chains[k];
      maxStart = k;
    }
  }
}
