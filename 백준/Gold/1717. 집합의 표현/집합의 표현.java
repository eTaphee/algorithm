import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n = 0;

  static int operateCount = 0;

  static int[] array;

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());

    n = Integer.parseInt(tokenizer.nextToken());
    array = new int[n + 1];
    for (int i = 0; i < array.length; i++) {
      array[i] = i;
    }

    operateCount = Integer.parseInt(tokenizer.nextToken());
    for (int i = 0; i < operateCount; i++) {
      tokenizer = new StringTokenizer(br.readLine());

      int op = Integer.parseInt(tokenizer.nextToken());
      int a = Integer.parseInt(tokenizer.nextToken());
      int b = Integer.parseInt(tokenizer.nextToken());

      if (op == 1) {
        if (find(a) == find(b)) {
          sb.append("YES\n");
        } else {
          sb.append("NO\n");
        }
      } else {
        union(a, b);
      }
    }

    System.out.println(sb.toString());
  }

  static void union(int a, int b) {
    int min = Math.min(a, b);
    int max = Math.max(a, b);

    int root = find(min);
    setRoot(max, find(min));
    array[max] = root;
  }

  static void setRoot(int pos, int root) {
    if (array[pos] != pos) {
      setRoot(array[pos], root);
    } else {
      array[pos] = root;
    }
  }

  static int find(int a) {
    if (array[a] == a) {
      return a;
    }

    return array[a] = find(array[a]);
  }
}
