import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int M, N, H;
  static int[][][] box;
  static boolean[][][] visited;
  static int days;
  static int[][] dirs = new int[][]{
      {0, 0, 1}, // 위
      {0, 0, -1}, // 아래
      {0, 1, 0}, // 왼쪽
      {0, -1, 0}, // 오른쪽
      {1, 0, 0}, // 앞
      {-1, 0, 0} // 뒤
  };
  static Queue<Integer[]> queue = new LinkedList<>();
  static int totalCount = 0; // 익어야 하는 토마토 개수
  static int checkedCount = 0; // 확인한 토마토 개수

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    M = Integer.parseInt(tokenizer.nextToken());
    N = Integer.parseInt(tokenizer.nextToken());
    H = Integer.parseInt(tokenizer.nextToken());
    box = new int[M][N][H];
    visited = new boolean[M][N][H];

    for (int i = 0; i < H; i++) {
      for (int j = 0; j < N; j++) {
        tokenizer = new StringTokenizer(br.readLine());
        for (int k = 0; k < M; k++) {
          int value = Integer.parseInt(tokenizer.nextToken());
          box[k][j][i] = value;
          if (value == 1) {
            queue.add(new Integer[]{k, j, i});
          }
          totalCount += (value != -1) ? 1 : 0;
        }
      }
    }

    while (!queue.isEmpty()) {
      Integer[] pos = queue.poll();
      int x = pos[0];
      int y = pos[1];
      int z = pos[2];
      if (visited[x][y][z]) {
        continue;
      }

      totalCount--;
      visited[x][y][z] = true;

      for (int[] dir : dirs) {
        int nX = x + dir[0];
        int nY = y + dir[1];
        int nZ = z + dir[2];
        if (movable(nX, nY, nZ)) {
          queue.add(new Integer[]{nX, nY, nZ});
          box[nX][nY][nZ] = box[x][y][z] + 1;
          days = Math.max(days, box[nX][nY][nZ]);
        }
      }
    }

    if (totalCount > 0) {
      days = -1;
    }

    if (days > 0) {
      days--;
    }

    System.out.println(days);

//    for (int i = 0; i < H; i++) {
//      for (int j = 0; j < N; j++) {
//        for (int k = 0; k < M; k++) {
//          System.out.print(box[k][j][i] + " ");
//        }
//        System.out.println();
//      }
//    }
  }

  static boolean movable(int x, int y, int z) {
    return (x >= 0 && x < M
        && y >= 0 && y < N
        && z >= 0 && z < H
        && !visited[x][y][z]
        && box[x][y][z] == 0);
  }
}
