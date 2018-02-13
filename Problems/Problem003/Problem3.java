// find the largest prime factor of 600851475143
public class Problem3 {
  public static void main(String[] args){
    long numb = 600851475143L;
    long i = 2L;
    while (i < numb/2){
      if(numb % i == 0)
        numb = numb/i;
      else
        i++;
    }
  System.out.println(numb);
  }
}
