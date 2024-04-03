import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    Queue<Integer> queue = new PriorityQueue<>();
    for (int i = 0; i < N; i++) {
      int x = Integer.parseInt(br.readLine());
      if (x == 0) {
        sb.append(queue.isEmpty() ? 0 : queue.poll()).append("\n");
      } else {
        queue.add(x);
      }
    }
    System.out.println(sb);
  }
}
