public class Problem002{
  public static void main(String[] args){
    long limit = 4000000;

    long fibCurr = 2;
    long fibPrev = 1;
    long temp = 0;

    long sum = 0;

    while(fibCurr < limit) {
      if(fibCurr % 2 == 0) {
        sum += fibCurr;
      }
      temp = fibCurr;
      fibCurr += fibPrev;
      fibPrev = temp;
    }

    System.out.println(sum);
  }
}
