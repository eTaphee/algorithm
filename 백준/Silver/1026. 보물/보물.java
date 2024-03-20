import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static Integer[] A, B;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    A = new Integer[N];
    B = new Integer[N];
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(tokenizer.nextToken());
    }
    tokenizer = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      B[i] = Integer.parseInt(tokenizer.nextToken());
    }

    Arrays.sort(A);
    Arrays.sort(B, Comparator.reverseOrder());

    int sum = 0;
    for (int i = 0; i < N; i++) {
      sum += A[i] * B[i];
    }
    System.out.println(sum);
  }
}
