import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    List<Node> list = new ArrayList<>();
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(tokenizer.nextToken());
    int M = Integer.parseInt(tokenizer.nextToken());
    int prePower = 0;
    for (int i = 0; i < N; i++) {
      tokenizer = new StringTokenizer(br.readLine());
      String title = tokenizer.nextToken();
      int power = Integer.parseInt(tokenizer.nextToken());

      if (!list.isEmpty() && list.get(list.size() - 1).to == power) {
        continue;
      }

      list.add(new Node(title, prePower, power));
      prePower = power + 1;
    }

    // 100_000

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < M; i++) {
      int power = Integer.parseInt(br.readLine());
      int left = 0;
      int right = list.size();
      while (left < right) {
        int mid = (left + right) / 2;
        Node node = list.get(mid);
        int range = node.range(power);
        if (range == 0) {
          sb.append(node.title).append("\n");
          break;
        } else if (range == -1) {
          right = mid;
        } else {
          left = mid;
        }
      }
    }
    System.out.println(sb);
  }

  static class Node {

    String title;
    int from;
    int to;

    Node(String title, int from, int to) {
      this.title = title;
      this.from = from;
      this.to = to;
    }

    int range(int power) {
      if (power < from) {
        return -1;
      } else if (power <= to) {
        return 0;
      } else {
        return 1;
      }
    }
  }
}
