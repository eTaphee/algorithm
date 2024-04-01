import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static int N, M;
  static int[][] space;
  static int[][] dirs = new int[][]{
      {1, -1}, {1, 0}, {1, 1}
  };
  static int minFuel = Integer.MAX_VALUE;
  static int fuel = 0;
  static int[] preMoved = new int[2];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    N = Integer.parseInt(tokenizer.nextToken());
    M = Integer.parseInt(tokenizer.nextToken());
    space = new int[N][M];
    for (int i = 0; i < N; i++) {
      tokenizer = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        space[i][j] = Integer.parseInt(tokenizer.nextToken());
      }
    }

    for (int i = 0; i < M; i++) {
      fuel = 0;
      dfs(0, i, preMoved);
    }

    System.out.println(minFuel);
  }

  static void dfs(int x, int y, int[] preDir) {
    fuel += space[x][y];
    if (fuel > minFuel) {
      return;
    }

    // 끝에 도달하면 소모 연료 비교
    if (x == N - 1) {
      minFuel = Math.min(fuel, minFuel);
      return;
    }

    for (int[] dir : dirs) {
      int nextX = x + dir[0];
      int nextY = y + dir[1];
      if (movable(nextX, nextY, dir)) {
        preMoved = dir;
        dfs(nextX, nextY, dir);
        preMoved = preDir;
        fuel -= space[nextX][nextY];
      }
    }
  }

  static boolean movable(int x, int y, int[] dir) {
    return (x >= 0 && x < N &&
        y >= 0 && y < M
        && !Arrays.equals(dir, preMoved));
  }
}
// 8
// 5
// 9
// 1
// 5
// 4
