import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

  static int k;

  static boolean[] visited = new boolean[10];

  static String[] A;

  static int[] minArray;
  static int[] maxArray;
  static int[] num;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    k = Integer.parseInt(br.readLine());
    A = new String[k];

    minArray = new int[k + 1];
    Arrays.fill(minArray, 9);

    maxArray = new int[k + 1];
    Arrays.fill(maxArray, 0);

    num = new int[k + 1];
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    for (int i = 0; i < k; i++) {
      A[i] = tokenizer.nextToken();
    }

    dfs(0);

    print(maxArray);
    print(minArray);
  }

  static void dfs(int cur) {
    if (cur == k + 1) {
      long result = toNum(num);
      long max = toNum(maxArray);
      long min = toNum(minArray);
      if (num[0] == 9) {
        toNum(num);
      }
      if (result > max) {
        maxArray = Arrays.stream(num).toArray();
      }
      if (result < min) {
        minArray = Arrays.stream(num).toArray();
      }
      return;
    }

    for (int i = 0; i <= 9; i++) {
      if (!visited[i]) {
        visited[i] = true;

        num[cur] = i;

        boolean ok = true;
        if (cur > 0) {
          String op = A[cur - 1];
          if (Objects.equals(op, ">")) {
            ok = num[cur - 1] > num[cur];
          } else {
            ok = num[cur - 1] < num[cur];
          }
        }

        if (ok) {

          dfs(cur + 1);
        } else {
          num[cur] = 0;
        }

        visited[i] = false;
      }
    }
  }

  static long toNum(int[] arr) {
    long result = 0;
    int pow = 0;

    for (int i = arr.length - 1; i >= 0; i--) {
      result += (long) (Math.pow(10, pow++) * arr[i]);
    }

    return result;
  }

  static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]);
    }
    System.out.println();
  }
}

