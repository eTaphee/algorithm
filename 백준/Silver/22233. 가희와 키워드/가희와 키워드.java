import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(tokenizer.nextToken());
    int M = Integer.parseInt(tokenizer.nextToken());
    Set<String> note = new HashSet<>();
    for (int i = 0; i < N; i++) {
      note.add(br.readLine());
    }

    StringBuilder sb = new StringBuilder();
    for (int i =0; i < M; i++) {
      for (String keyword : br.readLine().split(",")) {
        note.remove(keyword);
      }
      sb.append(note.size()).append("\n");
    }
    System.out.println(sb);
  }
}
