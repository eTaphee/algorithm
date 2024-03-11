import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int N = 0;
  static int M = 0;

  static ArrayList<Integer>[] students;
  static boolean[] visited;
  static int[] inDegrees;
  static List<Integer> sorted = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());

    N = Integer.parseInt(tokenizer.nextToken());
    M = Integer.parseInt(tokenizer.nextToken());

    students = new ArrayList[N + 1];
    visited = new boolean[N + 1];
    inDegrees = new int[N + 1];
    for (int i = 0; i < students.length; i++) {
      students[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      tokenizer = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(tokenizer.nextToken());
      int B = Integer.parseInt(tokenizer.nextToken());

      students[A].add(B);
      students[B].add(A);
      inDegrees[B]++;
    }

    int start = next();
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    visited[start] = true;

    while (!queue.isEmpty()) {
      Integer poll = queue.poll();
      visited[poll] = true;
      sorted.add(poll);

      for (int next : students[poll]) {
        if (inDegrees[next] > 0) {
          inDegrees[next]--;
        }
      }

      int index = next();
      if (index >= 0) {
        queue.add(index);
      }
    }

    for (int num : sorted) {
      System.out.print(num + " ");
    }
    System.out.println();
  }

  static int next() {
    for (int i = 1; i < students.length; i++) {
      if (!visited[i] && inDegrees[i] == 0) {
        return i;
      }
    }

    return -1;
  }
}
