import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  final static String Equilateral = "Equilateral";
  final static String Isosceles = "Isosceles";
  final static String Scalene = "Scalene";
  final static String Invalid = "Invalid";

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;

    while ((line = br.readLine()) != null) {
      StringTokenizer tokenizer = new StringTokenizer(line);
      int a = Integer.parseInt(tokenizer.nextToken());
      int b = Integer.parseInt(tokenizer.nextToken());
      int c = Integer.parseInt(tokenizer.nextToken());
      if (a == 0 && b == 0 && c == 0) {
        break;
      }
      print(a, b, c);
    }
  }

  static void print(int a, int b, int c) {
    int[] array = new int[]{a, b, c};
    Arrays.sort(array);

    a = array[0];
    b = array[1];
    c = array[2];

    if (a == b && b == c) {
      System.out.println(Equilateral);
    } else if ((a == b && a + b > c) || (b == c && b + c > a)) {
      System.out.println(Isosceles);
    } else if (a + b > c) {
      System.out.println(Scalene);
    } else {
      System.out.println(Invalid);
    }
  }
}
