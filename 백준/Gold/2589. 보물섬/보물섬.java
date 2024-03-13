import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int W, H;
  static char[][] map;
  static boolean[][] visited;
  static int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
  static final char LAND = 'L';
  static Queue<Integer[]> lands = new LinkedList<>();
  static int[][] distances;
  static int maxDistance = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());

    W = Integer.parseInt(tokenizer.nextToken());
    H = Integer.parseInt(tokenizer.nextToken());
    map = new char[W][H];

    for (int i = 0; i < W; i++) {
      String line = br.readLine();
      for (int j = 0; j < H; j++) {
        map[i][j] = line.charAt(j);
        if (map[i][j] == LAND) {
          lands.add(new Integer[]{i, j});
        }
      }
    }

    while (!lands.isEmpty()) {
      visited = new boolean[W][H];
      distances = new int[W][H];

      Integer[] land = lands.poll();
      Queue<Integer[]> queue = new LinkedList<>();
      queue.add(land);
      visited[land[0]][land[1]] = true;

      Integer[] last = null;
      while (!queue.isEmpty()) {
        last = queue.poll();
        int x = last[0];
        int y = last[1];

        for (int[] dir : dirs) {
          int nextX = x + dir[0];
          int nextY = y + dir[1];

          if (movable(nextX, nextY)) {
            queue.add(new Integer[]{nextX, nextY});
            visited[nextX][nextY] = true;
            distances[nextX][nextY] = distances[x][y] + 1;
          }
        }
      }

      maxDistance = Math.max(maxDistance, distances[last[0]][last[1]]);
    }

    System.out.println(maxDistance);
  }

  static boolean movable(int x, int y) {
    return (x >= 0 && x < W
        && y >= 0 && y < H
        && !visited[x][y]
        && map[x][y] == LAND);
  }
}
