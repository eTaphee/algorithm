import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

  static int N, K;
  static HashMap<Integer, Integer> map = new HashMap<>();
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
      count++;
      map.put(num, map.getOrDefault(num, 0) + 1);
      Integer curCount = map.get(num);
      while (curCount != null && curCount > K) {
        int startNum = arr[start];
        map.put(startNum, map.get(startNum) - 1);
        curCount = map.get(num);
        start++;
        count--;
      }
      max = Math.max(max, count);
    }
    System.out.println(max);
  }
}