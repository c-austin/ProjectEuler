import java.util.*;

public class Problem043 {
  public static void main(String[] args) {
    ArrayList<Long> list = new ArrayList<Long>();

    for(int i = 500; i < 600; i++) {
      if(i % 11 == 0 && distinctDigits(i)){
        list.add((long) i);
      }
    }

    int lim = list.size();

    for(int i = 0; i < lim; i++) {
      long num = list.get(0);
      list.remove(0);
      for(int k = 0; k < 10; k++) {
        long temp = (num % 100) * 10 + k;
        if(temp % 13 == 0 && distinctDigits(num * 10 + k)) {
          list.add((long) num * 10 + k);
        }
      }
    }

    lim = list.size();

    for(int i = 0; i < lim; i++) {
      long num = list.get(0);
      list.remove(0);
      for(int k = 0; k < 10; k++) {
        long temp = (num % 100) * 10 + k;
        if(temp % 17 == 0 && distinctDigits(num * 10 + k)) {
          list.add((long) num * 10 + k);
        }
      }
    }

    lim = list.size();

    for(int i = 0; i < lim; i++) {
      long num = list.get(0);
      list.remove(0);
      for(int k = 0; k < 10; k++) {
        long temp = num / 1000 + 100 * k;
        if(temp % 7 == 0 && distinctDigits(100000 * k + num)) {
          list.add((long) 100000 * k + num);
        }
      }
    }

    lim = list.size();

    for(int i = 0; i < lim; i++) {
      long num = list.get(0);
      list.remove(0);
      for(int k = 0; k < 10; k += 2) {
        if(distinctDigits(1000000L * k + num)) {
          list.add(1000000L * k + num);
        }
      }
    }

    lim = list.size();

    for(int i = 0; i < lim; i++) {
      long num = list.get(0);
      list.remove(0);
      for(int k = 0; k < 10; k++) {
        long temp = num / 100000L + 100 * k;
        if(temp % 3 == 0 && distinctDigits(10000000L * k + num)) {
          list.add(10000000L * k + num);
        }
      }
    }

    lim = list.size();

    for(int i = 0; i < lim; i++) {
      long num = list.get(0);
      list.remove(0);
      for(int k = 10; k < 99; k++) {
        long temp = 100000000L * k + num;
        if(distinctDigits(temp)) {
          list.add(temp);
        }
      }
    }

    long sum = 0L;

    for(long k : list) {
      sum += k;
    }
    System.out.println(sum);
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
}
