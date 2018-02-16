public class Problem009 {
  public static void main(String[] args) {
    for(int c = 498; c >= 335; c--) {
      for(int b = c - 1; b > 333; b--) {
        int a = 1000 - b - c;
        if(a * a + b * b == c * c) {
          System.out.println(a * b * c);
        }
      }
    }
  }
}
