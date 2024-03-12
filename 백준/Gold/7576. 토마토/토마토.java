import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int M, N;
  static int[][] box;
  static boolean[][] visited;
  static int[][] moves = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
  static Queue<Integer[]> tomatoes = new LinkedList<>();
  static int notyet = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());

    M = Integer.parseInt(tokenizer.nextToken());
    N = Integer.parseInt(tokenizer.nextToken());
    box = new int[N][M];
    visited = new boolean[N][M];
    for (int i = 0; i < N; i++) {
      tokenizer = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        int tomato = Integer.parseInt(tokenizer.nextToken());
        if (tomato == 1) {
          tomatoes.add(new Integer[]{i, j, 0});
        } else if (tomato == 0) {
          notyet++;
        }
        box[i][j] = tomato;
      }
    }

    if (notyet == 0) {
      System.out.println(0);
      return;
    }

    int lastDay = 0;
    while (!tomatoes.isEmpty()) {
      Integer[] node = tomatoes.poll();
      int x = node[0];
      int y = node[1];
      int day = node[2];
      if (visited[x][y]) {
        continue;
      }

      visited[x][y] = true;

      if (box[x][y] == 0) {
        box[x][y] = 1;
        notyet--;
        lastDay = day;
      }

      if (box[x][y] == 1) {
        for (int[] move : moves) {
          int nextX = x + move[0];
          int nextY = y + move[1];

          if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M
              && !visited[nextX][nextY]) {
            tomatoes.add(new Integer[]{nextX, nextY, day + 1});
          }
        }
      }
    }

    if (notyet > 0) {
      System.out.println(-1);
      return;
    }

    System.out.println(lastDay);
  }
}