import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int[] dp = new int[46];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    System.out.println(fibo(n));
  }

  static int fibo(int n) {
    if (dp[n] != 0) {
      return dp[n];
    }

    if (n == 0) {
      return 0;
    } else if (n <= 2) {
      return dp[n] = 1;
    }

    return dp[n] = fibo(n - 1) + fibo(n - 2);
  }
}
