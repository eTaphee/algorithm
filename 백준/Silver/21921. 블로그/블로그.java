import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N, X;
  static int[] visitor;

  static int max = 0;

  static int visitorsInRange = 0;

  static int count = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    N = Integer.parseInt(tokenizer.nextToken());
    X = Integer.parseInt(tokenizer.nextToken());
    visitor = new int[N];
    tokenizer = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      visitor[i] = Integer.parseInt(tokenizer.nextToken());
      if (i < X) {
        visitorsInRange += visitor[i];
      }
    }

    max = visitorsInRange;
    count = 1;
    for (int i = 0; i < N - X; i++) {
      visitorsInRange = visitorsInRange - visitor[i] + visitor[i + X];
      if (max < visitorsInRange) {
        max = visitorsInRange;
        count = 1;
      } else if (max == visitorsInRange) {
        count++;
      }
    }

    if (max == 0) {
      System.out.println("SAD");
    } else {
      System.out.println(max);
      System.out.println(count);
    }
  }
}
