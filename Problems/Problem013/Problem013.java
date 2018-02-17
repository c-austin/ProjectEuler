import java.util.*;
import java.io.*;

public class Problem013 {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("Problem013.txt"));

    long sum = 0L;

    String str;

    while(in.hasNext()) {
      str = in.nextLine();
      sum += Long.parseLong(str.substring(0,12));
    }

    while(sum >= 10000000000L) {
      sum /= 10;
    }
    System.out.println(sum);

  }
}
