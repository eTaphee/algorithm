import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  static int N;
  static int[][] map;
  static boolean[][] visited;
  static int[][] moves = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
  static List<Integer> apt = new ArrayList<>();
  static int count = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    visited = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      String[] split = br.readLine().split("");
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(split[j]);
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visited[i][j]) {
          dsf(i, j);
          if (count > 0) {
            apt.add(count);
            count = 0;
          }
        }
      }
    }

    Collections.sort(apt);
    System.out.println(apt.size());
    apt.forEach(System.out::println);
  }

  static void dsf(int x, int y) {
    if (visited[x][y]) {
      return;
    }

    visited[x][y] = true;

    if (map[x][y] == 0) {
      return;
    }

    count++;

    for (int[] move : moves) {
      int nextX = x + move[0];
      int nextY = y + move[1];

      if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
        if (map[nextX][nextY] == 1) {
          dsf(nextX, nextY);
        }
      }
    }
  }
}
