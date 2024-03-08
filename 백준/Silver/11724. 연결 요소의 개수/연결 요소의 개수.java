import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  // 정점 개수
  static int N = 0;

  // 간선 개수
  static int M = 0;

  static ArrayList<Integer>[] graph;

  static int connectedComponent = 0;

  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());

    N = Integer.parseInt(tokenizer.nextToken());
    M = Integer.parseInt(tokenizer.nextToken());

    graph = new ArrayList[N + 1];
    visited = new boolean[N + 1];
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      tokenizer = new StringTokenizer(br.readLine());

      int u = Integer.parseInt(tokenizer.nextToken());
      int v = Integer.parseInt(tokenizer.nextToken());

      graph[u].add(v);
      graph[v].add(u);
    }

    for (int i = 1; i < graph.length; i++) {
      if (!visited[i]) {
        connectedComponent++;
      }

      dfs(i);
    }

    System.out.println(connectedComponent);
  }

  static void dfs(int node) {
    if (visited[node]) {
      return;
    }

    visited[node] = true;

    for (int linked : graph[node]) {
      dfs(linked);
    }
  }
}
