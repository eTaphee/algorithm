import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static int N, L;
  static int[] point;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    N = Integer.parseInt(tokenizer.nextToken());
    L = Integer.parseInt(tokenizer.nextToken());
    point = new int[N];
    tokenizer = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      point[i] = Integer.parseInt(tokenizer.nextToken());
    }
    Arrays.sort(point);

    int distance;
    int count = 1;
    int start = 0;
    for (int i = 1; i < N; i++) {
      distance = point[i] - point[start];
      if (distance >= L) {
        start = i;
        count++;
      }
    }
    System.out.println(count);
  }
}
