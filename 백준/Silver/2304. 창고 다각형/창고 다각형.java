import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] maxColumn = new int[]{0, 0};
    Stack<int[]> stack = new Stack<>();
    List<int[]> list = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      StringTokenizer tokenizer = new StringTokenizer(br.readLine());
      int pos = Integer.parseInt(tokenizer.nextToken());
      int height = Integer.parseInt(tokenizer.nextToken());

      int[] column = new int[]{pos, height};
      list.add(column);
      list.sort(Comparator.comparingInt((int[] col) -> col[0]));
    }

    for (int[] column : list) {
      if (stack.isEmpty()) {
        stack.push(column);
      } else {
        if (maxColumn[1] > column[1]) {
          while (stack.peek()[1] <= column[1]) {
            stack.pop();
          }
          stack.push(column);
        } else if (maxColumn[1] <= column[1]) {
          while (stack.peek()[1] < maxColumn[1]) {
            stack.pop();
          }
          stack.push(column);
        } else {
          stack.push(column);
        }
      }
      if (column[1] >= maxColumn[1]) {
        maxColumn = column;
      }
    }

    if (stack.size() == 1) {
      System.out.println(stack.peek()[1]);
      System.exit(0);
    }

    int area = 0;
    int[] prev = null;

    for (int[] column : stack) {
      if (prev != null) {
        if (column[1] >= prev[1]) {
          area += (column[0] - prev[0]) * prev[1];
        } else {
          area += (column[0] - prev[0]) * column[1] + (prev[1] - column[1]);
        }
        if (column == stack.peek()) {
          area += column[1];
        }
      }
      prev = column;
    }

    System.out.println(area);
  }
}
// 또..반례 다 넣었는데 에러나네..

//5
//    1 5
//    2 4
//    3 2
//    4 3
//    5 1
// 정답 16, 출력 15