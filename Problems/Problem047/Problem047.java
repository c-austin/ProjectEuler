public class Problem047 {
  public static void main(String[] args) {
    int limit = 2000000;
    int factNum = 4;
    int[] numOfPriFact = new int[limit + 1];
    int count = 0;

    for(int i = 2; i <= limit; i++) {
      if(numOfPriFact[i] == 0) {
        for(int j = 2; j * i <= limit; j++) {
          numOfPriFact[i * j]++;
        }
      }
      if(numOfPriFact[i] >= factNum) {
        count++;
      } else {
        count = 0;
        continue;
      }
      if(count == factNum) {
        System.out.println(i - factNum + 1);
        break;
      }
    }
  }
}
