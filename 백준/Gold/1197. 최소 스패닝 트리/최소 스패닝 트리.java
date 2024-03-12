import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static int V, E;
  static List<Edge> edges = new ArrayList<>();
  static int[] degrees;
  static List<Integer> weights = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    V = Integer.parseInt(tokenizer.nextToken());
    E = Integer.parseInt(tokenizer.nextToken());
    degrees = new int[V + 1];
    for (int i = 1; i < degrees.length; i++) {
      degrees[i] = i;
    }

    for (int i = 0; i < E; i++) {
      tokenizer = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(tokenizer.nextToken());
      int B = Integer.parseInt(tokenizer.nextToken());
      int C = Integer.parseInt(tokenizer.nextToken());
      edges.add(new Edge(A, B, C));
    }

    edges.sort(Comparator.comparingInt(o -> o.weight));

    for (int i = 0; i < edges.size(); i++) {
      Edge current = edges.get(i);

      if (find(current.start) != find(current.end)) {
        union(current.start, current.end);
        weights.add(current.weight);
      }

      if (weights.size() == V - 1) {
        break;
      }
    }

    System.out.println(weights.stream().reduce(0, Integer::sum));
  }

  static void union(int a, int b) {
    a = find(a);
    b = find(b);

    if (a != b) {
      degrees[a] = b;
    }
  }

  static int find(int num) {
    if (degrees[num] == num) {
      return num;
    }

    return degrees[num] = find(degrees[num]);
  }

  static class Edge {

    int start;
    int end;
    int weight;

    Edge(int start, int end, int weight) {
      this.start = start;
      this.end = end;
      this.weight = weight;
    }
  }
}
