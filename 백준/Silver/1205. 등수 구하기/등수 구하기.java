import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int score;
  static int P;
  static int rank;
  static List<Integer> rankList = new ArrayList<>();


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());

    N = Integer.parseInt(tokenizer.nextToken());
    score = Integer.parseInt(tokenizer.nextToken());
    P = Integer.parseInt(tokenizer.nextToken());

    if (N > 0) {
      tokenizer = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        rankList.add(Integer.parseInt(tokenizer.nextToken()));
      }
    }

    rankList.sort(Comparator.reverseOrder());

    // 랭크 리스트에 올라갈 수 없을 정도로 낮은 경우 -1
    if (!rankList.isEmpty()) {
      int last = rankList.get(rankList.size() - 1);
      if (N == P && score <= last) {
        System.out.println(-1);
        System.exit(0);
      }
    }

    rank = 1;
    for (int current : rankList) {
      if (current >= score) {
        rank++;
        if (current == score) {
          rank--;
          break;
        }
      } else {
        break;
      }
    }
    System.out.println(rank);
  }
}
