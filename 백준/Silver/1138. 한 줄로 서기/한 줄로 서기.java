import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int left = Integer.parseInt(tokenizer.nextToken());
      int idx = 0;
      int cnt = 0;
      while (cnt < left) {
        if (arr[idx++] == 0) {
          cnt++;
        }
      }
      while (arr[idx] != 0) {
        idx++;
      }
      arr[idx] = i + 1;
    }
    for (int man : arr) {
      System.out.printf("%d ", man);
    }
    System.out.println();
  }
}
