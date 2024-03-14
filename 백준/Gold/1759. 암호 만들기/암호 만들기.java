import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

  // 최소 한 개의 모음(a, e, i, o, u)
  // 최소 두 개의 자음
  static int L, C;

  static Character[] chars;

  static SortedSet<Character> cipher = new TreeSet<>();

  static boolean[] visited;

  static Set<Character> 모음셋 = new HashSet<>();

  static Set<String> sortedSet = new TreeSet<>();

  static int 모음수 = 0;

  static int 자음수 = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    L = Integer.parseInt(tokenizer.nextToken());
    C = Integer.parseInt(tokenizer.nextToken());

    모음셋.add('a');
    모음셋.add('e');
    모음셋.add('i');
    모음셋.add('o');
    모음셋.add('u');

    chars = new Character[C];
    visited = new boolean[C];
    tokenizer = new StringTokenizer(br.readLine());
    for (int i = 0; i < C; i++) {
      chars[i] = tokenizer.nextToken().charAt(0);
    }

    comb(0, L);

    sortedSet.forEach(System.out::println);
  }

  static void comb(int start, int r) {
    if (r == 0) {
      if (satisfied()) {
        StringBuilder sb = new StringBuilder();
        for (Character ch : cipher) {
          sb.append(ch);
        }
        sortedSet.add(sb.toString());
      }
      return;
    }

    for (int i = start; i < chars.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        char ch = chars[i];
        if (모음셋.contains(ch)) {
          모음수++;
        } else {
          자음수++;
        }
        cipher.add(ch);
        comb(i + 1, r - 1);
        visited[i] = false;
        if (모음셋.contains(ch)) {
          모음수--;
        } else {
          자음수--;
        }
        cipher.remove(ch);
      }
    }
  }

  static boolean satisfied() {
    return 모음수 >= 1 && 자음수 >= 2;
  }
}
