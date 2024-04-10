import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int[] dish;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(tokenizer.nextToken()); // 접시 수
    int d = Integer.parseInt(tokenizer.nextToken()); // 초밥 가짓수
    int k = Integer.parseInt(tokenizer.nextToken()); // 연속해서 먹는 접시 수
    int c = Integer.parseInt(tokenizer.nextToken()); // 쿠폰 번호

    dish = new int[N];
    for (int i = 0; i < N; i++) {
      dish[i] = Integer.parseInt(br.readLine());
    }

    Queue<Integer> eat = new LinkedList<>();
    Map<Integer, Integer> map = new HashMap<>();

    int max = 0;
    int idx = 0;
    while (true) {
      // k접시를 먹은 상태면..
      if (eat.size() == k) {
        Integer firstSushi = dish[eat.poll()];
        int count = map.get(firstSushi) - 1;
        if (count > 0) {
          map.put(firstSushi, count);
        } else {
          map.remove(firstSushi);
        }
      }

      if (eat.size() < k) {
        int sushi = dish[idx];
        eat.offer(idx);
        map.put(sushi, map.getOrDefault(sushi, 0) + 1);
        idx = (idx < dish.length - 1) ? idx + 1 : 0;
      }

      // k접시를 먹었으면
      if (eat.size() == k) {
        if (map.containsKey(c)) {
          // 쿠폰 스시를 포함해서 먹었으면.. 그대로
          max = Math.max(max, map.size());
        } else {
          // 쿠폰 스시를 안먹었으면 추가해준다.
          max = Math.max(max, map.size() + 1);
        }
      }

      if (idx == k - 1 && eat.size() == k) {
        break;
      }
    }
    System.out.println(max);
  }
}
