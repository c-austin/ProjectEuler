public class Problem006 {
  public static void main(String[] args){
    int n = 100;
    double ans = (3 * Math.pow(n,4) + 2 * Math.pow(n,3) - 3 * Math.pow(n,2) - 2 * Math.pow(n,1))/12;
    System.out.println((int) ans);
  }
}
