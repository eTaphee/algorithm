import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int[] P;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    P = new int[N];
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      P[i] = Integer.parseInt(tokenizer.nextToken());
    }
    Arrays.sort(P);

    int total = P[0];
    for (int i = 1; i < N; i++) {
      P[i] = P[i - 1] + P[i];
      total += P[i];
    }
    System.out.println(total);
  }
}
