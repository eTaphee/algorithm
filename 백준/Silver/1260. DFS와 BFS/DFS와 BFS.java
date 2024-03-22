import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(tokenizer.nextToken());
    int M = Integer.parseInt(tokenizer.nextToken());
    int V = Integer.parseInt(tokenizer.nextToken());

    visited = new boolean[N + 1];
    for (int i = 0; i < N + 1; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      tokenizer = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(tokenizer.nextToken());
      int e = Integer.parseInt(tokenizer.nextToken());
      graph.get(s).add(e);
      graph.get(e).add(s);
    }
      
    for (int i = 0; i < graph.size(); i++) {
      Collections.sort(graph.get(i));
    }

    dfs(V);

    visited = new boolean[N + 1];
    System.out.println();

    bfs(V);
  }

  static void dfs(Integer v) {
    if (visited[v]) {
      return;
    }

    visited[v] = true;
    System.out.print(v + " ");

    ArrayList<Integer> nodes = graph.get(v);
    for (Integer node : nodes) {
      dfs(node);
    }
  }

  static void bfs(Integer v) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(v);

    while (!queue.isEmpty()) {
      Integer poll = queue.poll();

      if (visited[poll]) {
        continue;
      }

      visited[poll] = true;
      System.out.print(poll + " ");

      for (Integer node : graph.get(poll)) {
        if (!visited[node]) {
          queue.add(node);
        }
      }
    }
  }
}
