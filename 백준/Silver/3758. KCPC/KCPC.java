import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  static int T;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      StringTokenizer tokenizer = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(tokenizer.nextToken());
      int k = Integer.parseInt(tokenizer.nextToken());
      int myTeamId = Integer.parseInt(tokenizer.nextToken());
      int m = Integer.parseInt(tokenizer.nextToken());

      Map<Integer, Team> map = new HashMap<>();

      for (int j = 0; j < m; j++) {
        tokenizer = new StringTokenizer(br.readLine());
        int teamId = Integer.parseInt(tokenizer.nextToken());
        int no = Integer.parseInt(tokenizer.nextToken());
        int score = Integer.parseInt(tokenizer.nextToken());

        map.put(teamId, map.getOrDefault(teamId, new Team(teamId)));
        Team team = map.get(teamId);
        team.solve(no, score, j);
      }

      List<Team> list = new ArrayList<>(map.values());
      Collections.sort(list);

      int rank = 1;
      for (Team team : list) {
        if (team.id == myTeamId) {
          break;
        }
        rank++;
      }
      System.out.println(rank);
    }
  }

  static class Team implements Comparable<Team> {

    int id;
    int lastSubmit;
    int submitCount;
    Map<Integer, Integer> problems;

    Team(int id) {
      this.id = id;
      problems = new HashMap<>();
    }

    public void solve(int num, int score, int submitSeq) {
      problems.put(num, Math.max(score, problems.getOrDefault(num, 0)));
      submitCount++;
      lastSubmit = submitSeq;
    }

    @Override
    public int compareTo(Team o) {
      return comparator.compare(this, o);
    }

    private static final Comparator<Team> comparator =
        Comparator.comparingInt(
                (Team team) -> team.problems.values().stream().reduce(0, Integer::sum))
            .reversed()
            .thenComparingInt(team -> team.submitCount)
            .thenComparingInt(team -> team.lastSubmit);
  }
}
