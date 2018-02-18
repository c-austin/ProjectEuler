public class Problem036 {
  public static void main(String[] args) {
    char[] lastDig = {'1','3','5','7','9'};
    char[] dig = {'0','1','2','3','4','5','6','7','8','9'};

    long sum = 0L;

    int temp = 0;

    for(int i = 0; i < 5; i++) {
      temp = evenLenPali("" + lastDig[i]);
      if(isBinPali(temp)) {
        sum += temp;
      }
      temp = oddLenPali("" + lastDig[i]);
      if(isBinPali(temp)) {
        sum += temp;
      }
      for(int j = 0; j < 10; j++) {
        temp = evenLenPali("" + dig[j] + lastDig[i]);
        if(isBinPali(temp)) {
          sum += temp;
        }
        temp = oddLenPali("" + dig[j] + lastDig[i]);
        if(isBinPali(temp)) {
          sum += temp;
        }
        for(int k = 0; k < 10; k++) {
          temp = evenLenPali("" + dig[k] + dig[j] + lastDig[i]);
          if(isBinPali(temp)) {
            sum += temp;
          }
          temp = oddLenPali("" + dig[k] + dig[j] + lastDig[i]);
          if(isBinPali(temp)) {
            sum += temp;
          }
        }
      }
    }
    System.out.println(sum);
  }


  public static int evenLenPali(String str) {
    String pali = str;
    for(int i = 0; i < str.length(); i++) {
      pali = str.charAt(i) + pali;
    }
    return Integer.parseInt(pali);
  }

  public static int oddLenPali(String str) {
    String pali = str;
    for(int i = 1; i < str.length(); i++) {
      pali = str.charAt(i) + pali;
    }
    return Integer.parseInt(pali);
  }

  public static boolean isBinPali(int n) {
    String str = Integer.toBinaryString(n);
    for(int i = 0; i < str.length() / 2; i++) {
      if(str.charAt(i) != str.charAt(str.length() - 1 - i)) {
        return false;
      }
    }
    return true;
  }
}
