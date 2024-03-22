import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

  static int M;
  static Set<Integer> set = new HashSet<>();
  static Set<String> noValueOp = new HashSet<>() {{
    add("all");
    add("empty");
  }};

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    M = Integer.parseInt(br.readLine());
    for (int i = 0; i < M; i++) {
      StringTokenizer tokenizer = new StringTokenizer(br.readLine());
      String op = tokenizer.nextToken();
      if (noValueOp.contains(op)) {
        switch (op) {
          case "all":
            IntStream.range(1, 21).forEach(m -> set.add(m));
            break;
          case "empty":
            set.clear();
            break;
        }
      } else {
        int value = Integer.parseInt(tokenizer.nextToken());
        switch (op) {
          case "add":
            set.add(value);
            break;
          case "remove":
            set.remove(value);
            break;
          case "check":
            sb.append(set.contains(value) ? 1 : 0).append("\n");
            break;
          case "toggle": {
            if (set.contains(value)) {
              set.remove(value);
            } else {
              set.add(value);
            }
          }
        }
      }
    }
    System.out.println(sb);
  }
}
