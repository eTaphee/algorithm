import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  static int N, K;
  static Queue<Location> queue = new LinkedList<>();
  static Set<Integer> visited = new HashSet<>();
  static int sec = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());

    N = Integer.parseInt(tokenizer.nextToken());
    K = Integer.parseInt(tokenizer.nextToken());

    queue.add(new Location(N, sec++));

    while (!queue.isEmpty()) {
      Location loc = queue.poll();
      if (visited.contains(loc.dist) || loc.dist < 0 || loc.dist > 100_000) {
        continue;
      }

      if (loc.dist == K) {
        sec = loc.sec;
        break;
      }

      visited.add(loc.dist);

      queue.add(loc.blink());
      queue.add(loc.forward());
      queue.add(loc.backward());
    }

    System.out.println(sec);
  }

  static class Location {

    int dist;
    int sec;

    Location(int dist, int sec) {
      this.dist = dist;
      this.sec = sec;
    }

    Location backward() {
      return new Location(dist - 1, sec + 1);
    }

    Location forward() {
      return new Location(dist + 1, sec + 1);
    }

    Location blink() {
      return new Location(dist * 2, sec + 1);
    }
  }
}
