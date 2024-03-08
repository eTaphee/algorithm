import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  static int computerCount = 0;
  static int computerPairCount = 0;
  static ArrayList<Integer>[] network;
  static int infectedCount = 0;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    computerCount = Integer.parseInt(br.readLine());
    computerPairCount = Integer.parseInt(br.readLine());

    network = new ArrayList[computerCount + 1];
    visited = new boolean[computerCount + 1];
    for (int i = 0; i < network.length; i++) {
      network[i] = new ArrayList<>();
    }

    for (int i = 0; i < computerPairCount; i++) {
      StringTokenizer tokenizer = new StringTokenizer(br.readLine());
      int com1 = Integer.parseInt(tokenizer.nextToken());
      int com2 = Integer.parseInt(tokenizer.nextToken());

      network[com1].add(com2);
      network[com2].add(com1);
    }

    dsf(1);

    // computer 1은 제외
    System.out.println(infectedCount - 1);
  }

  static void dsf(int computer) {
    if (visited[computer]) {
      return;
    }

    visited[computer] = true;
    infectedCount++;

    for (int linked : network[computer]) {
      dsf(linked);
    }
  }
}
