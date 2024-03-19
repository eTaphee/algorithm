import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

  static int N, M;

  static SortedSet<String> nMembers = new TreeSet<>();
  static SortedSet<String> mMembers = new TreeSet<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    N = Integer.parseInt(tokenizer.nextToken());
    M = Integer.parseInt(tokenizer.nextToken());

    for (int i = 0; i < N; i++) {
      nMembers.add(br.readLine());
    }

    for (int i = 0; i < M; i++) {
      mMembers.add(br.readLine());
    }

    nMembers.retainAll(mMembers);

    System.out.println(nMembers.size());
    nMembers.forEach(System.out::println);
  }
}
