import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int H, W, N, M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    H = Integer.parseInt(tokenizer.nextToken());
    W = Integer.parseInt(tokenizer.nextToken());
    N = Integer.parseInt(tokenizer.nextToken());
    M = Integer.parseInt(tokenizer.nextToken());
    int row = (int) Math.ceil(H / (double) (N + 1));
    int col = (int) Math.ceil(W / (double) (M + 1));
    System.out.println(row * col);
  }
}
