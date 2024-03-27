import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

  static Integer N, score, P;

  static Integer[] ranking;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());

    N = Integer.parseInt(tokenizer.nextToken());
    score = Integer.parseInt(tokenizer.nextToken());
    P = Integer.parseInt(tokenizer.nextToken());
    ranking = new Integer[P];

    if (N == 0) {
      System.out.println(1);
      System.exit(0);
    }

    tokenizer = new StringTokenizer(br.readLine());
    for (int i = 0; i < P; i++) {
      if (tokenizer.hasMoreTokens()) {
        ranking[i] = Integer.parseInt(tokenizer.nextToken());
      } else {
        ranking[i] = -1;
      }
    }

    // 점수 내림차순 정렬
    Arrays.sort(ranking, Comparator.reverseOrder());

    int rank = -1;
    for (int i = 0; i < P; i++) {
      Integer cur = ranking[i];

      int comp = cur.compareTo(score);
      if (comp <= 0) {
        if (i == P - 1 && comp == 0) { // 위치가 마지막이고 점수가 같으면 들어갈 수 없음
          break;
        }

        if (score.compareTo(ranking[P - 1]) == 0) {
          break;
        }

        rank = i + 1;
        break;
      }
    }

    System.out.println(rank);
  }
}

