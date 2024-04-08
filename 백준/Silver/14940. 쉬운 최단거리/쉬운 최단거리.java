import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int[][] map;
  static boolean[][] visited;
  static int goalX = 0;
  static int goalY = 0;
  static int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
  static int N, M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());

    N = Integer.parseInt(tokenizer.nextToken());
    M = Integer.parseInt(tokenizer.nextToken());

    map = new int[N][M];
    visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      tokenizer = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(tokenizer.nextToken());
        if (map[i][j] == 2) {
          goalX = i;
          goalY = j;
        }
      }
    }

    bfs(goalX, goalY);

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (visited[i][j]) {
          System.out.print(map[i][j] + " ");
        } else if (map[i][j] != 0) {
          System.out.print(-1 + " ");
        } else {
          System.out.print(map[i][j] + " ");
        }

      }
      System.out.println();
    }
  }

  static void bfs(int x, int y) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{x, y});
    visited[x][y] = true;
    map[x][y] = 0;

    while (!queue.isEmpty()) {
      int[] poll = queue.poll();

      for (int[] dir : dirs) {
        int nextX = poll[0] + dir[0];
        int nextY = poll[1] + dir[1];

        if (isMovable(nextX, nextY)) {
          queue.add(new int[]{nextX, nextY});
          visited[nextX][nextY] = true;
          map[nextX][nextY] = map[poll[0]][poll[1]] + 1;
        }
      }
    }
  }

  static boolean isMovable(int x, int y) {
    return (x >= 0 && x < N && y >= 0 && y < M && !visited[x][y] && map[x][y] == 1);
  }
}
