import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N; // 도시 개수 2 <= N M= 100_000

  static int[] distances;

  static int[] prices;

  static long remain;

  static int currentCity;

  static long totalPrice;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    distances = new int[N];
    prices = new int[N];

    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    for (int i = 0; i < distances.length - 1; i++) {
      distances[i] = Integer.parseInt(tokenizer.nextToken());
      remain += distances[i];
    }

    tokenizer = new StringTokenizer(br.readLine());
    for (int i = 0; i < prices.length; i++) {
      prices[i] = Integer.parseInt(tokenizer.nextToken());
    }

    while (remain > 0) {
      // 더 낮은 가격의 도시를 찾아야해..
      int nextCity = 0;
      for (int i = currentCity; i < prices.length; i++) {
        if (prices[i] < prices[currentCity]) {
          nextCity = i;
          break;
        }
      }

      if (nextCity == 0) {
        nextCity = prices.length - 1;
      }

      // 찾았으면 그 도시까지 가야하는 거리의 양을 현재 주유소에서 충전
      long distanceToNextCity = 0;
      for (int i = currentCity; i < nextCity; i++) {
        distanceToNextCity += distances[i];
      }

      totalPrice += ((long) distanceToNextCity * prices[currentCity]);
      remain -= distanceToNextCity;
      currentCity = nextCity;
    }

    System.out.println(totalPrice);
  }
}
