import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  static int x;
  static int n;
  static List<Integer> blocks = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String line;
    while ((line = br.readLine()) != null && !line.isEmpty()) {
      x = Integer.parseInt(line) * 10_000_000;
      n = Integer.parseInt(br.readLine());

      blocks.clear();
      for (int i = 0; i < n; i++) {
        blocks.add(Integer.parseInt(br.readLine()));
      }
      Collections.sort(blocks);

      int left = 0;
      int right = blocks.size() - 1;
      boolean found = false;

      while (left < right) {
        int lb = blocks.get(left);
        int rb = blocks.get(right);
        int sum = lb + rb;
        
        if (sum == x) {
          System.out.printf("yes %d %d\n", lb, rb);
          found = true;
          break;
        }

        if (sum > x) {
          right--;
        } else {
          left++;
        }
      }

      if (!found) {
        System.out.println("danger");
      }
    }
  }
}

// 25% 실패