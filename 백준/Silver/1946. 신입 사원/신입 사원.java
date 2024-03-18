import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static int T;
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      N = Integer.parseInt(br.readLine());

      List<Test> list = new ArrayList<>();
      for (int j = 0; j < N; j++) {
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int score1 = Integer.parseInt(tokenizer.nextToken());
        int score2 = Integer.parseInt(tokenizer.nextToken());
        list.add(new Test(score1, score2));
      }
      Collections.sort(list);

      int count = 1; // 1부터 시작, score1 기준으로 오름차순 정렬이기 때문에 무조건 합격
      Test lasted = list.get(0);
      for (int j = 1; j < list.size(); j++) {
        Test current = list.get(j);
        if (current.score2 < lasted.score2) {
          count++;
          lasted = current;
        }
      }

      System.out.println(count);
    }
  }

  static class Test implements Comparable<Test> {

    int score1;
    int score2;

    Test(int score1, int score2) {
      this.score1 = score1;
      this.score2 = score2;
    }

    @Override
    public int compareTo(Test o) {
      return Integer.compare(this.score1, o.score1);
    }
  }
}
