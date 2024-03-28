import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static int N, M;
  static List<Position> positions = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    positions.add(new Position(0, false));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      positions.add(new Position(Integer.parseInt(tokenizer.nextToken()), true));
    }
    positions.add(new Position(N, false));

    int max = 0;
    for (int i = 0; i < positions.size(); i++) {
      Position cur = positions.get(i);
      Position pre = (i > 0) ? positions.get(i - 1) : cur;

      if (cur.light && pre.light) {
        max = Math.max(max, (int) Math.ceil((cur.pos - pre.pos) / 2.0));
      } else {
        max = Math.max(max, cur.pos - pre.pos);
      }
    }
    System.out.println(max);
  }

  static class Position {

    int pos;
    boolean light;

    Position(int pos, boolean light) {
      this.pos = pos;
      this.light = light;
    }
  }
}
