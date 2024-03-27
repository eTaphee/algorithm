import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
      List<Team> teams = new ArrayList<>();
      for (int race : races) {
        if (participants.get(race) == 6) {
          if (!scoreMap.containsKey(race)) {
            Team team = new Team(race);
            scoreMap.put(race, team);
            teams.add(team);
          }
          Team team = scoreMap.get(race);
          if (team.count < 4) {
            team.score += seq;
          } else if (team.count == 4) {
            team.five = seq;
          }
          team.count++;
          seq++;
        }
      }

      teams.sort((t1, t2) -> {
        int comp = Integer.compare(t1.score, t2.score);
        return (comp == 0) ? Integer.compare(t1.five, t2.five) : comp;
      });

      System.out.println(teams.get(0).num);
    }
  }

  static class Team {

    int num;
    int score;
    int count;
    int five;

    Team(int num) {
      this.num = num;
    }
  }
}