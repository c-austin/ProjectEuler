public class Problem205 {
  public static int[] countA = new int[37];
  public static int[] countB = new int[37];

  public static void main(String[] args) {
    long start = System.nanoTime();
    function(6,0,6);
    function(9,0,4);

    double chanceA = 1.0 / Math.pow(4,9);
    double chanceB = 1.0 / Math.pow(6,6);

    double[] oddsA = new double[37];
    double[] oddsB = new double[37];

    for(int k = 0; k < 37; k++) {
      oddsA[k] = countA[k] * chanceA;
      oddsB[k] = countB[k] * chanceB;
    }

    double output = 0;
    double tempSum = 0;

    for(int i = 36; i >= 0; i--) {
      tempSum = 0;
      for(int j = i - 1; j >= 0; j--) {
        tempSum += oddsB[j];
      }
      output += oddsA[i] * tempSum;
    }
    long time = System.nanoTime() - start;
    System.out.println(time);
    System.out.println(time / 1000);
    System.out.println(time / 1000000);
    System.out.println(output);


  }

  public static void function(int diceLeft, int currentSum, int numOfSides) {
    if(diceLeft == 0) {
      if(numOfSides == 4) {
        countA[currentSum]++;
      }
      if(numOfSides == 6) {
        countB[currentSum]++;
      }
    } else {
      for(int i = 1; i <= numOfSides; i++) {
        function(diceLeft - 1, currentSum + i, numOfSides);
      }
    }
  }
}
