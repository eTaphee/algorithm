import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    
  static int N;
  static Set<String> players = new HashSet<>();
  static Map<String, Integer> map = new HashMap<>() {{
    put("Y", 1);
    put("F", 2);
    put("O", 3);
  }};
  static int count = 0;
  static int required = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    N = Integer.parseInt(tokenizer.nextToken());
    required = map.get(tokenizer.nextToken());
    for (int i = 0; i < N; i++) {
      if (players.add(br.readLine())
          && players.size() % required == 0) {
        count++;
      }
    }
    System.out.println(count);
  }
}
