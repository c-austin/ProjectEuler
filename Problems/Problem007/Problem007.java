public class Problem007 {
  public static void main(String[] args) {
    int count = 0;
    int target = 10001;
    int num = 1;
    while(count < target) {
      num++;
      if(isPrime(num)) {
        count++;
      }
    }
    System.out.println(num);
  }

  public static boolean isPrime(int n) {
    if(n < 2) {
      return false;
    }
    if(n < 4) {
      return true;
    }
    if(n % 2 == 0 || n % 3 == 0){
      return false;
    }
    if(n < 10) {
      return true;
    }

    int lim = (int) Math.sqrt(n);

    for(int i = 5; i <= lim; i += 2) {
      if(n % i == 0) {
        return false;
      }
    }
    return true;
  }
}
