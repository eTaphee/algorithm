import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int P;
  static int[][] test;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    P = Integer.parseInt(br.readLine());
    test = new int[P + 1][20];
    for (int i = 0; i < P; i++) {
      StringTokenizer tokenizer = new StringTokenizer(br.readLine());
      int T = Integer.parseInt(tokenizer.nextToken());
      int prev = 0;
      int move = 0;
      for (int j = 0; j < 20; j++) {
        int height = Integer.parseInt(tokenizer.nextToken());
        int idx = j;
        if (prev > height) {
          idx = getNewIdx(test[T], height);
          System.arraycopy(test[T], idx, test[T], idx + 1, j - idx);
          move += (j - idx);
        }
        test[T][idx] = height;
        prev = test[T][j];
      }
//      System.out.println(Arrays.toString(test[T]));
      sb.append(String.format("%d %d", T, move)).append("\n");
    }
    System.out.println(sb);
  }

  static int getNewIdx(int[] arr, int height) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > height) {
        return i;
      }
    }
    return 0;
  }
}

//1
//1 1 2 3 10 11 12 4 5 6 7 8 9 20 19 18 13 14 15 16 17