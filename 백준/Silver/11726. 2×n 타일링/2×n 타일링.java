import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    dp = new int[n + 1];
    System.out.println(recursive(n));
  }

  static int recursive(int n) {
    if (dp[n] > 0) {
      return dp[n];
    }

    if (n <= 2) {
      return dp[n] = n;
    }

    return dp[n] = (recursive(n - 1) + recursive(n - 2)) % 10_007;
  }
}
