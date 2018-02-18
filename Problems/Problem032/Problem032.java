import java.util.*;

public class Problem032{
  public static void main(String[] args) {
    int sum = 0;

    HashSet<Integer> products = new HashSet<Integer>();

    for(int i = 10; i < 100; i++) {
      for(int j = 100; j * i <= 9876; j++) {
        int k = i * j;
        if(k < 1234) {
          continue;
        }
        if(isPanDigital(concatenate(i,concatenate(j,k)))) {
          products.add(k);
        }
      }
    }

    for(int i = 1; i < 10; i++) {
      for(int j = 1000; j * i <= 9876; j++) {
        int k = i * j;
        if(k < 1234) {
          continue;
        }
        if(isPanDigital(concatenate(i,concatenate(j,k)))) {
          products.add(k);
        }
      }
    }

    for(int k : products) {
      sum += k;
    }

    System.out.println(sum);

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

  public static long concatenate(long m, long n) {
    long copy = n;
    while(copy > 0) {
      m *= 10;
      copy /= 10;
    }
    return m + n;
  }
}
