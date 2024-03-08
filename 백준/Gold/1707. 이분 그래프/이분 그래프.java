import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  static int K = 0;
  static String A = "A";
  static String B = "B";

  static ArrayList<Integer>[] graph;
  static boolean[] visited;
  static int[] checked;
  static boolean isBitPartite = true;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    K = Integer.parseInt(br.readLine());

    for (int i = 0; i < K; i++) {
      StringTokenizer tokenizer = new StringTokenizer(br.readLine());
      int V = Integer.parseInt(tokenizer.nextToken());
      int E = Integer.parseInt(tokenizer.nextToken());

      graph = new ArrayList[V + 1];
      visited = new boolean[V + 1];
      checked = new int[V + 1];
      isBitPartite = true;

      for (int j = 0; j < graph.length; j++) {
        graph[j] = new ArrayList<>();
      }

      for (int j = 0; j < E; j++) {
        tokenizer = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(tokenizer.nextToken());
        int v = Integer.parseInt(tokenizer.nextToken());

        graph[u].add(v);
        graph[v].add(u);
      }

      for (int j = 1; j < graph.length; j++) {
        if (isBitPartite) {
          dfs(j);
        } else {
          break;
        }
      }

      if (isBitPartite) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }

  static void dfs(int node) {
    visited[node] = true;

    for (Integer linked : graph[node]) {
      if (!visited[linked]) {
        checked[linked] = (checked[node] + 1) % 2;
        dfs(linked);
       } else if (checked[node] == checked[linked]) {
        isBitPartite = false;
      }
    }
  }
}
