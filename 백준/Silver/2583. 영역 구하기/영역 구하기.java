import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static int[][] paper;
  static boolean[][] visited;
  static List<Integer> area = new ArrayList<>();
  static int M, N, K;
  static int size = 0;
  static int[][] moves = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());

    M = Integer.parseInt(tokenizer.nextToken());
    N = Integer.parseInt(tokenizer.nextToken());
    K = Integer.parseInt(tokenizer.nextToken());

    paper = new int[M][N];
    visited = new boolean[M][N];

    for (int i = 0; i < K; i++) {
      tokenizer = new StringTokenizer(br.readLine());
      int ly = Integer.parseInt(tokenizer.nextToken());
      int lx = Integer.parseInt(tokenizer.nextToken());
      int ry = Integer.parseInt(tokenizer.nextToken());
      int rx = Integer.parseInt(tokenizer.nextToken());

      for (int x = lx; x < rx; x++) {
        for (int y = ly; y < ry; y++) {
          paper[x][y] = 1;
        }
      }
    }

    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        size = 0;
        if (!visited[i][j]) {
          dsf(i, j, paper[i][j]);
          if (size > 0) {
            area.add(size);
          }
        }
      }
    }

    Collections.sort(area);
    System.out.println(area.size());
    for (int size : area) {
      System.out.print(size + " ");
    }
    System.out.println();
  }

  static void dsf(int x, int y, int value) {
    if (visited[x][y]) {
      return;
    }

    visited[x][y] = true;

    if (paper[x][y] == 0) {
      size++;
    }

    for (int[] move : moves) {
      int nextX = x + move[0];
      int nextY = y + move[1];

      if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
        if (value == paper[nextX][nextY]) {
          dsf(nextX, nextY, value);
        }
      }
    }
  }
}
