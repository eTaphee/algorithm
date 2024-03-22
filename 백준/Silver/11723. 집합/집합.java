import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  static int M;
  static Set<Integer> set = new HashSet<>();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    M = Integer.parseInt(br.readLine());
    for (int i = 0; i < M; i++) {
      StringTokenizer tokenizer = new StringTokenizer(br.readLine());
      String op = tokenizer.nextToken();
      if ("all".equals(op)) {
        for (int n = 1; n <= 20; n++) {
          set.add(n);
        }
      } else if ("empty".equals(op)) {
        set.clear();
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
