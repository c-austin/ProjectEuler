import java.util.*;
import java.io.*;

public class Problem022 {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("Problem022.txt")).useDelimiter("\"");
    String input = "";

    while(in.hasNext()) {
      input += in.next();
    }

    String[] names = input.split(",");
    Arrays.sort(names);

    String current = "";
    int charSum = 0;
    int total = 0;
    char c = 'A';

    for(int i = 0; i < names.length; i++) {
      charSum = 0;
      current = names[i];
      for(int j = 0; j < current.length(); j++) {
        c = current.charAt(j);
        if(!Character.isLetter(c)) {
          continue;
        }
        charSum += current.charAt(j) - 'A' + 1;
      }
      total += charSum * (i + 1);
    }
    System.out.println(total);
  }
}
