import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static List<Room> rooms = new LinkedList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    int p = Integer.parseInt(tokenizer.nextToken());
    int m = Integer.parseInt(tokenizer.nextToken());

    for (int i = 0; i < p; i++) {
      tokenizer = new StringTokenizer(br.readLine());
      int level = Integer.parseInt(tokenizer.nextToken());
      String nick = tokenizer.nextToken();

      Room room = findRoom(level);
      if (room == null) {
        room = new Room(m, level);
        rooms.add(room);
      }
      room.players.add(new Player(level, nick));
    }

    rooms.forEach(r -> {
      r.players.sort(Comparator.comparing((player -> player.nick)));

      System.out.println(r.started() ? "Started!" : "Waiting!");
      for (Player player : r.players) {
        System.out.printf("%d %s%n", player.level, player.nick);
      }
    });
  }

  static Room findRoom(int level) {
    return rooms.stream().filter(r -> r.matched(level)).findFirst().orElse(null);
  }

  static class Room {

    List<Player> players;
    int max;
    int from;
    int to;

    Room(int max, int level) {
      this.players = new ArrayList<>();
      this.max = max;
      this.from = level - 10;
      this.to = level + 10;
    }

    boolean matched(int level) {
      return level >= from && level <= to && players.size() < max;
    }

    boolean started() {
      return max == players.size();
    }
  }

  static class Player {

    int level;
    String nick;

    Player(int level, String nick) {
      this.level = level;
      this.nick = nick;
    }
  }
}
