import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N, M;

  static int[] budget;

  static int exceed = 0;

  static int required = 0;

  static int max = 0;

//  static int min = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    budget = new int[N];
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      budget[i] = Integer.parseInt(tokenizer.nextToken());
      required += budget[i];
      max = Math.max(max, budget[i]);
//      min = Math.min(min, budget[i]);
    }
    M = Integer.parseInt(br.readLine());
    exceed = required - M;

    if (exceed <= 0) {
      System.out.println(max);
    } else {
      while (true) {
        max--;
        int sum = 0;
        for (int i = 0; i < N; i++) {
          if (budget[i] < max) {
            sum += budget[i];
          } else {
            sum += max;
          }
        }
        if (sum <= M) {
          break;
        }
      }
      System.out.println(max);
    }
  }
}

