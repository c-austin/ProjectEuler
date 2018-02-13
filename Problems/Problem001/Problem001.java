public class Problem001 {

  final static int max = 999;

  public static void main(String[] args){
    System.out.println(sumDivBy(3) + sumDivBy(5) - sumDivBy(15));
  }

  public static int sumDivBy(int n) {
    int lim = max / n;
    return n * lim * (lim + 1) / 2;
  }
}
