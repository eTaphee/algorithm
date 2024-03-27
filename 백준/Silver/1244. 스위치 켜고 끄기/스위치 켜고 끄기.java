import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int swCount;
  static int stdCount;
  static int[] switches;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    swCount = Integer.parseInt(br.readLine());
    switches = new int[swCount];
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    for (int i = 0; i < swCount; i++) {
      switches[i] = Integer.parseInt(tokenizer.nextToken());
    }
    stdCount = Integer.parseInt(br.readLine());
    for (int i = 0; i < stdCount; i++) {
      tokenizer = new StringTokenizer(br.readLine());

      int gender = Integer.parseInt(tokenizer.nextToken());
      int num = Integer.parseInt(tokenizer.nextToken());

      if (gender == 1) {
        for (int j = 0; j < swCount; j++) {
          if ((j + 1) % num == 0) {
            switches[j] = (switches[j] + 1) % 2;
          }
        }
      } else {
        int left = 0;
        int right = (num > 0) ? num - 1 : left;

        switches[right] = (switches[right] + 1) % 2;

        while (left < right) {
          left++;

          int leftPos = right - left;
          int rightPos = right + left;

          if (leftPos >= 0 && leftPos < right && rightPos > right && rightPos < swCount) {
            if (switches[leftPos] == switches[rightPos]) {
              switches[leftPos] = (switches[leftPos] + 1) % 2;
              switches[rightPos] = (switches[rightPos] + 1) % 2;
            } else {
              break;
            }
          }
        }
      }
    }

    for (int i = 0; i < swCount; i++) {
      System.out.print(switches[i] + " ");
      if ((i + 1) % 20 == 0) {
        System.out.println();
      }
    }
    System.out.println();
  }
}
