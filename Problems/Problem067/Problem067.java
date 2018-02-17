import java.util.*;
import java.io.*;

public class Problem067 {
  public static void main(String[] args) throws FileNotFoundException {
    int rows = 100;
    int[][] triangle = new int[rows + 1][rows + 1];

    Scanner in = new Scanner(new File("Problem067.txt"));

    for(int i = 1; i <= rows; i++) {
      for(int j = 1; j <= i; j++) {
        triangle[i][j] = in.nextInt() + max(triangle[i - 1][j],triangle[i - 1][j - 1]);
      }
    }

    int output = 0;
    for(int j = 1; j <= rows; j++) {
      int temp = triangle[rows][j];
      if(temp > output) {
        output = temp;
      }
    }
    System.out.println(output);

  }
  public static int max(int a, int b) {
    if(a > b) {
      return a;
    } else {
      return b;
    }
  }
}
