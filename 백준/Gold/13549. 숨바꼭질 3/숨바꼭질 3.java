import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(tokenizer.nextToken());
    int K = Integer.parseInt(tokenizer.nextToken());
    List<List<int[]>> graph = new ArrayList<>();
    boolean[] visited = new boolean[100_000 + 1];
    int[] seconds = new int[100_000 + 1];

    for (int i = 0; i < 100_000 + 1; i++) {
      seconds[i] = Integer.MAX_VALUE;

      graph.add(new ArrayList<>());

      List<int[]> edges = graph.get(i);
      int a = i - 1;
      edges.add(new int[]{a, 1});
      int b = i + 1;
      if (b <= K + 1) {
        edges.add(new int[]{b, 1});
      }
      int c = i * 2;
      if (c <= K + 1) {
        edges.add(new int[]{c, 0});
      }
    }

    seconds[N] = 0;
    if (N + 1 < K + 1) {
      seconds[N + 1] = 1;
    }

    if (N - 1 >= 0) {
      seconds[N - 1] = 1;
    }

    if (N * 2 < K + 1) {
      seconds[N * 2] = 0;
    }

    Queue<Integer> queue = new LinkedList<>();
    queue.offer(N);
    visited[N] = true;

    while (!queue.isEmpty()) {
      Integer pos = queue.poll();
      int curWeight = seconds[pos];

      for (int[] edge : graph.get(pos)) {
        int nextPos = edge[0];
        int weight = edge[1];
        if (nextPos >= 0 && nextPos <= 100_000) {
          if (!visited[nextPos]) {
            queue.offer(nextPos);
            visited[nextPos] = true;
          }
          seconds[nextPos] = Math.min(seconds[nextPos], curWeight + weight);
        }
      }
    }

    System.out.println(seconds[K]);
  }
}
