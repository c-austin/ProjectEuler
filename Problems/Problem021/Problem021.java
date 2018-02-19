public class Problem21 {
  public static void main(String[] args) {
    int sum = 0;
    int j , k;
    for(int i = 2; i <= 10000; i++) {
      j = divisorSum(i);
      if(j > i) {
        if(i == divisorSum(j)) {
          sum += i + j;
        }
      }
    }
    System.out.println(sum);

  }

  public static int divisorSum(int n) {
    int sum = 1;
    int sqrt = (int) Math.sqrt(n);
    if(n % sqrt == 0) {
      sum += sqrt;
    }
    for(int i = 2; i < sqrt; i++) {
      if(n % i == 0) {
        sum = sum + i + n/i;
      }
    }
    return sum;
  }
}
