import java.math.*;

public class Problem020 {
  public static void main(String[] args) {
    int limit = 100;
    int sum = 0;
    BigInteger prod = BigInteger.valueOf(1);

    for(int i = 2; i <= limit; i++) {
      prod = prod.multiply(BigInteger.valueOf(i));
    }

    String num = prod.toString();

    for(int i = 0; i < num.length(); i++) {
      sum += num.charAt(i) - '0';
    }

    System.out.println(sum);
  }
}
