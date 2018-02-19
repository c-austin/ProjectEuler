public class Problem016 {
  public static void main(String[] args) {
    // algoritm works for base 0-9 and powers which are positive integers
    int power = 1000;
    int base = 2;

    int length = (int) Math.ceil(power * Math.log10(base));
    int[] digits = new int[length];
    digits[0] = 1;

    int carry = 0;
    int temp = 0;
    int limit = 0;

    for(int i = 0; i < power; i++) {

      limit = (int) Math.ceil(i * Math.log10(base));

      for(int j = 0; j <= limit; j++) {
        temp = digits[j] * base + carry;
        carry = temp / 10;
        digits[j] = temp % 10;
      }
    }
    
    int sum = 0;
    for(int k : digits) {
      sum += k;
    }
    System.out.println(sum);
  }
}
