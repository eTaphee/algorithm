import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int[] dp = new int[1000000 + 1];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int recursive = recursive(N);
    System.out.println(recursive);
  }

  static int recursive(int n) {
    if (dp[n] != 0 || n == 1) {
      return dp[n];
    }

    if (n >= 1 && n <= 3) {
      return dp[n] = 1;
    }

    if (n % 6 == 0) {
      return dp[n] =
          1 + Math.min(recursive(n / 2), Math.min(recursive(n / 3), recursive(n - 1)));
    } else if (n % 2 == 0) {
      return dp[n] = 1 + Math.min(recursive(n / 2), recursive(n - 1));
    } else if (n % 3 == 0) {
      return dp[n] = 1 + Math.min(recursive(n / 3), recursive(n - 1));
    } else {
      return dp[n] = 1 + recursive(n - 1);
    }
  }
}
