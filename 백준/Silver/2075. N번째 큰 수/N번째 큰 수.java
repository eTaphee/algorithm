import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i = 0; i < N; i++) {
      StringTokenizer tokenizer = new StringTokenizer(br.readLine());
      while (tokenizer.hasMoreTokens()) {
        queue.offer(Integer.parseInt(tokenizer.nextToken()));
      }
    }
    while (N-- > 1) {
      queue.poll();
    }
    System.out.println(queue.poll());
  }
}
