public class Problem005{
  public static void main(String[] args) {
    int input = 20;
    int output = 1;

    boolean[] counted = new boolean[input + 1];

    for(int i = 2; i <= input; i++) {
      if(counted[i] == true) {
        continue;
      }
      for(int j = i; j <= input; j *= i) {
        output *= i;
      }
      for(int j = 1; j * i <= input; j++) {
        counted[i * j] = true;
      }
    }
    System.out.println(output);
  }
}
