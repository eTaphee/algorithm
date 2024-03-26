import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int N;
  static char[][] arr;
  static Integer[][] partIndexes = new Integer[7][2];
  final static int HEAD = 0;
  final static int LEFT_ARM = 1;
  final static int LEFT_LEG = 2;
  final static int LEFT_LEG_END = 3;
  final static int RIGHT_ARM = 4;
  final static int RIGHT_LEG = 5;
  final static int RIGHT_LEG_END = 6;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new char[N][N];
    for (int i = 0; i < N; i++) {
      arr[i] = br.readLine().toCharArray();

      // 머리를 먼저 찾는다.
      if (partIndexes[HEAD][0] == null) {
        for (int j = 0; j < arr[i].length; j++) {
          if (arr[i][j] == '*') {
            partIndexes[HEAD][0] = i;
            partIndexes[HEAD][1] = j;
          }
        }
      } else {
        // 왼쪽 탐색
        int headCol = partIndexes[HEAD][1];

        // 왼팔
        if (partIndexes[LEFT_ARM][0] == null) {
          for (int j = 0; j < headCol; j++) {
            if (arr[i][j] == '*') {
              partIndexes[LEFT_ARM][0] = i;
              partIndexes[LEFT_ARM][1] = j;
              break;
            }
          }
        }

        // 왼다리
        if (partIndexes[LEFT_ARM][0] != null
            && i > partIndexes[LEFT_ARM][0]
            && partIndexes[LEFT_LEG][0] == null
            && arr[i][headCol - 1] == '*') {
          partIndexes[LEFT_LEG][0] = i;
          partIndexes[LEFT_LEG][1] = headCol - 1;
        }

        // 왼다리 끝
        if (partIndexes[LEFT_LEG][0] != null &&
        i > partIndexes[LEFT_LEG][0]
            && arr[i][headCol - 1] == '*') {
          partIndexes[LEFT_LEG_END][0] = i;
          partIndexes[LEFT_LEG_END][1] = headCol - 1;
        }

        // 오른팔
        if (partIndexes[RIGHT_ARM][0] == null) {
          for (int j = N - 1; j >= headCol - 1; j--) {
            if (arr[i][j] == '*') {
              partIndexes[RIGHT_ARM][0] = i;
              partIndexes[RIGHT_ARM][1] = j;
              break;
            }
          }
        }

        // 오른다리
        if (partIndexes[RIGHT_ARM][0] != null
            && i > partIndexes[RIGHT_ARM][0]
            && partIndexes[RIGHT_LEG][0] == null
            && arr[i][headCol + 1] == '*') {
          partIndexes[RIGHT_LEG][0] = i;
          partIndexes[RIGHT_LEG][1] = headCol + 1;
        }

        // 오른다리 끝
        if (partIndexes[RIGHT_LEG][0] != null &&
            i > partIndexes[RIGHT_LEG][0]
            && arr[i][headCol + 1] == '*') {
          partIndexes[RIGHT_LEG_END][0] = i;
          partIndexes[RIGHT_LEG_END][1] = headCol + 1;
        }
      }
    }

    if (partIndexes[LEFT_LEG_END][0] == null) {
      partIndexes[LEFT_LEG_END][0] = partIndexes[LEFT_LEG][0];
      partIndexes[LEFT_LEG_END][1] = partIndexes[LEFT_LEG][1];
    }

    if (partIndexes[RIGHT_LEG_END][0] == null) {
      partIndexes[RIGHT_LEG_END][0] = partIndexes[RIGHT_LEG][0];
      partIndexes[RIGHT_LEG_END][1] = partIndexes[RIGHT_LEG][1];
    }

    int heartX = partIndexes[LEFT_ARM][0] + 1;
    int heartY = partIndexes[HEAD][1] + 1;

    int leftArmSize = Math.abs(partIndexes[HEAD][1] - partIndexes[LEFT_ARM][1]);
    int rightArmSize = Math.abs(partIndexes[RIGHT_ARM][1] - partIndexes[HEAD][1]);
    int bodySize = Math.abs(partIndexes[LEFT_ARM][0] + 1 - partIndexes[LEFT_LEG][0]);
    int leftLegSize = Math.abs(partIndexes[LEFT_LEG][0] - partIndexes[LEFT_LEG_END][0]) + 1;
    int rightLegSize = Math.abs(partIndexes[RIGHT_LEG][0] - partIndexes[RIGHT_LEG_END][0]) + 1;

    System.out.printf("%d %d\n", heartX, heartY);
    System.out.printf("%d %d %d %d %d\n", leftArmSize, rightArmSize, bodySize, leftLegSize, rightLegSize);
  }
}
