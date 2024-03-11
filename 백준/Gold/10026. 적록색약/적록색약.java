import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int N;
  static String[][] colorMap;
  static boolean[][] visited;
  static int[][] moves = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  static int areaRGCount;
  static int areaAntiRGCount;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    colorMap = new String[N][N];
    visited = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      String[] split = br.readLine().split("");
      for (int j = 0; j < N; j++) {
        colorMap[i][j] = split[j];
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visited[i][j]) {
          areaAntiRGCount++;
          dsfAntiRG(i, j, colorMap[i][j]);
        }
      }
    }

    visited = new boolean[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visited[i][j]) {
          areaRGCount++;
          dsfRG(i, j, colorMap[i][j]);
        }
      }
    }

    System.out.print(areaRGCount + " " + areaAntiRGCount);
    System.out.println();
  }

  static void dsfRG(int x, int y, String color) {
    if (visited[x][y]) {
      return;
    }

    visited[x][y] = true;

    for (int[] move : moves) {
      int nextX = x + move[0];
      int nextY = y + move[1];

      if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
        String nextColor = colorMap[nextX][nextY];
        if (color.equals(nextColor)) {
          dsfRG(nextX, nextY, color);
        }
      }
    }
  }

  // 적녹색약
  static void dsfAntiRG(int x, int y, String color) {
    if (visited[x][y]) {
      return;
    }

    visited[x][y] = true;

    for (int[] move : moves) {
      int nextX = x + move[0];
      int nextY = y + move[1];

      if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
        String nextColor = colorMap[nextX][nextY];
        if ((color.equals("R") && (nextColor.equals("R") || nextColor.equals("G")))
            || (color.equals("G") && (nextColor.equals("R") || nextColor.equals("G")))
        ) {
          dsfAntiRG(nextX, nextY, nextColor);
        } else if (color.equals("B") && nextColor.equals("B")) {
          dsfAntiRG(nextX, nextY, color);
        }
      }
    }
  }
}
