import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N, K;
  static int[] countArr = new int[100_000 + 1];
  static int[] arr;
  static int max = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());

    N = Integer.parseInt(tokenizer.nextToken());
    K = Integer.parseInt(tokenizer.nextToken());
    arr = new int[N];

    tokenizer = new StringTokenizer(br.readLine());

    int start = 0;
    int count = 0;
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(tokenizer.nextToken());
      arr[i] = num;
      countArr[num]++;
      count++;
      while (countArr[num] > K) {
        int startNum = arr[start++];
        countArr[startNum]--;
        count--;
      }
      max = Math.max(max, count);
    }
    System.out.println(max);
  }
}