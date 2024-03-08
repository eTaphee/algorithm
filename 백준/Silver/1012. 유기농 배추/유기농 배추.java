import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int T, M, N, K = 0;
  static int bugCount = 0;
  static int[][] land;
  static boolean[][] visited;

  // 상, 하, 좌, 우
  static int moves[][] = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    T = Integer.parseInt(br.readLine());

    for (int test = 0; test < T; test++) {
      StringTokenizer tokenizer = new StringTokenizer(br.readLine());
      M = Integer.parseInt(tokenizer.nextToken());
      N = Integer.parseInt(tokenizer.nextToken());
      K = Integer.parseInt(tokenizer.nextToken());

      land = new int[M][N];
      visited = new boolean[M][N];
      bugCount = 0;

      for (int i = 0; i < K; i++) {
        tokenizer = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(tokenizer.nextToken());
        int y = Integer.parseInt(tokenizer.nextToken());
        land[x][y] = 1;
      }

      for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
          if (!visited[i][j] && land[i][j] == 1) {
            // 방문하지 않은 상태이면서 배추가 있는 땅인 경우
            bugCount++;
          }
          dsf(i, j);
        }
      }

      System.out.println(bugCount);
    }
  }

  static void dsf(int x, int y) {
    if (visited[x][y]) {
      return;
    }

    visited[x][y] = true;

    if (land[x][y] != 1) {
      return;
    }

    for (int[] move : moves) {
      int nextX = x + move[0];
      int nextY = y + move[1];

      if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
        dsf(nextX, nextY);
      }
    }
  }
}
