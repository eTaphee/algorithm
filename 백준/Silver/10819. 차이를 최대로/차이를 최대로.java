import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int[] A;
  static boolean[] visited;
  static int[] compose;

  static int MAX = Integer.MIN_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    A = new int[N];
    compose = new int[N];
    visited = new boolean[N];
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(tokenizer.nextToken());
    }

    Arrays.sort(A);

    dsf(0);

    System.out.println(MAX);
  }

  static void dsf(int cur) {
    if (cur == N) {
      MAX = Math.max(MAX, sum());
      return;
    }

    for (int i = 0; i < A.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        compose[cur] = A[i];
        dsf(cur + 1);
        visited[i] = false;
      }
    }
  }

  static void swap(int a, int b) {
    int tmp = A[a];
    A[a] = A[b];
    A[b] = tmp;
  }

  static int sum() {
    int sum = 0;
    for (int i = 0; i < N - 1; i++) {
      sum += Math.abs(compose[i] - compose[i+1]);
    }
    return sum;
  }
}
