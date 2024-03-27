import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
      int count = Integer.parseInt(br.readLine());

      Map<Integer, Integer> participants = new HashMap<>();
      int[] races = new int[count];

      StringTokenizer tokenizer = new StringTokenizer(br.readLine());
      for (int j = 0; j < count; j++) {
        int num = Integer.parseInt(tokenizer.nextToken());
        participants.put(num, participants.getOrDefault(num, 0) + 1);
        races[j] = num;
      }

      int seq = 1;
      Map<Integer, Team> scoreMap = new HashMap<>();
      for (int race : races) {
        if (participants.get(race) == 6) {
          if (!scoreMap.containsKey(race)) {
            scoreMap.put(race, new Team(race));
          }
          Team team = scoreMap.get(race);
          if (team.scores.size() < 4) {
            team.scores.add(seq);
          } else if (team.scores.size() == 4 && team.five == 0) {
            team.five = seq;
          }
          seq++;
        }
      }

      Team win = scoreMap.values().stream()
          .sorted(
              Comparator.comparingInt(Team::total).thenComparingInt(team -> team.five))
          .findFirst().get();

      System.out.println(win.num);
    }
  }

  static class Team {

    int num;
    List<Integer> scores;
    int five;

    Team(int num) {
      this.num = num;
      this.scores = new ArrayList<>();
    }

    int total() {
      return scores.stream().reduce(0, Integer::sum);
    }
  }
}