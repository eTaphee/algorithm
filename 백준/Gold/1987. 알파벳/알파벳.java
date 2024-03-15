import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  static char[][] board;
  static boolean[][] visited;
  static int R, C;
  static int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
  static int move = 0;
  static int max = 1;
  static Set<Character> history = new HashSet<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());

    R = Integer.parseInt(tokenizer.nextToken());
    C = Integer.parseInt(tokenizer.nextToken());
    board = new char[R][C];
    visited = new boolean[R][C];

    for (int i = 0; i < R; i++) {
      String line = br.readLine();
      board[i] = line.toCharArray();
    }

    dfs(0, 0);

    System.out.println(max);
  }

  static void dfs(int x, int y) {
    if (visited[x][y]) {
      return;
    }

    move++;
    visited[x][y] = true;
    history.add(board[x][y]);

    for (int[] dir : dirs) {
      int nx = x + dir[0];
      int ny = y + dir[1];

      if (movable(nx, ny)) {
        dfs(nx, ny);
        max = Math.max(max, move);
        move--;
        visited[nx][ny] = false;
        history.remove(board[nx][ny]);
      }
    }
  }

  static boolean movable(int x, int y) {
    return (x >= 0 && x < R
        && y >= 0 && y < C
        && !visited[x][y]
        && !history.contains(board[x][y]));
  }
}
