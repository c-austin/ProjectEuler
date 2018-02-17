public class Problem053 {
  public static void main(String[] args) {
    int sum = 0;
    int limit = 1000000;
    int n = 100;

    int[][] pascal = new int[n+1][n+1];

    for(int j = 0; j <= n; j++) {
      pascal[0][j] = 1;
    }

    int temp = 0;

    for(int i = 1; i <= (n + 1) / 2; i++) {
      for(int j = i; j < n - i + 1; j++) {
        if(i == j) {
          temp = 2 * pascal[i - 1][j];
          if(temp >= limit) {
            temp = limit;
            sum++;
          }
        } else {
          temp = pascal[i - 1][j] + pascal[i][j - 1];
          if(temp >= limit) {
            temp = limit;
            sum += 2;
          }
        }
          pascal[i][j] = temp;
      }
    }

    System.out.println(sum);
  }
}
