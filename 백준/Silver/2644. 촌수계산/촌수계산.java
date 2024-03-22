import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  static int n, m;
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  static int f1, f2;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    f1 = Integer.parseInt(tokenizer.nextToken());
    f2 = Integer.parseInt(tokenizer.nextToken());
    m = Integer.parseInt(br.readLine());

    visited = new boolean[n + 1];
    for (int i = 0; i < n + 1; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      tokenizer = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(tokenizer.nextToken());
      int e = Integer.parseInt(tokenizer.nextToken());
      graph.get(s).add(e);
      graph.get(e).add(s);
    }

    dfs(f1, 0);
    System.out.println(-1);
  }

  static void dfs(int node, int chonsu) {
    if (visited[node]) {
      return;
    }

    visited[node] = true;
    if (node == f2) {
      System.out.println(chonsu);
      System.exit(0);
    }

    for(Integer sub : graph.get(node)) {
      dfs(sub, chonsu + 1);
    }
  }
}
