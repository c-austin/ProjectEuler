import java.io.*;
import java.util.*;

public class Problem011 {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("Problem011.txt"));
    int[][] nums = new int[20][20];
    for(int i = 0; i < 20; i++) {
      for(int j = 0; j < 20; j++) {
        nums[i][j] = in.nextInt();
      }
    }
    int max = 0;
    int horizontal = horizontalMax(nums);
    int vertical = verticalMax(nums);
    int left = leftDiagonalMax(nums);
    int right = rightDiagonalMax(nums);

    if(horizontal > max) {
      max = horizontal;
    }
    if(vertical > max) {
      max = vertical;
    }
    if(left > max) {
      max = left;
    }
    if(right > max) {
      max = right;
    }
    System.out.println(max);
  }

  public static int horizontalMax(int[][] nums) {
    int max = 0;
    for(int i = 0; i < 20; i++) {
      for(int j = 0; j < 17; j++) {
        int product = nums[i][j] * nums[i][j + 1] * nums[i][j + 2] * nums[i][j + 3];
        if(product > max) {
          max = product;
        }
      }
    }
    return max;
  }

  public static int verticalMax(int[][] nums) {
    int max = 0;
    for(int i = 0; i < 17; i++) {
      for(int j = 0; j < 20; j++) {
        int product = nums[i][j] * nums[i + 1][j] * nums[i + 2][j] * nums[i + 3][j];
        if(product > max) {
          max = product;
        }
      }
    }
    return max;
  }

  public static int rightDiagonalMax(int[][] nums) {
    int max = 0;
    for(int i = 0; i < 17; i++) {
      for(int j = 0; j < 17; j++) {
        int product = nums[i][j] * nums[i + 1][j + 1] * nums[i + 2][j + 2] * nums[i + 3][j + 3];
        if(product > max) {
          max = product;
        }
      }
    }
    return max;
  }

  public static int leftDiagonalMax(int[][] nums) {
    int max = 0;
    for(int i = 0; i < 17; i++) {
      for(int j = 3; j < 20; j++) {
        int product = nums[i][j] * nums[i + 1][j - 1] * nums[i + 2][j - 2] * nums[i + 3][j - 3];
        if(product > max) {
          max = product;
        }
      }
    }
    return max;
  }
}
