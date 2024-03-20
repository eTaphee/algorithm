import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

  static int N;

  static int[] good;

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    good = new int[N];
    permutation(0, 0);
  }

  static void permutation(int cur, int usedIdx) {
    if (cur == N) {
      System.out.println(sb.toString());
      System.exit(0);
    }

    boolean[] used = new boolean[3];
    if (cur == 0) {
      // 제일 작은 수 앞자리가 1이니, 1만 조합
      used = new boolean[]{false, true, true};
    } else {
      // 다음 수에 선택 안되게..
      used[usedIdx] = true;
    }

    for (int i = 0; i < used.length; i++) {
      if (!used[i]) {
        used[i] = true;
        good[cur] = i + 1;
        sb.append(good[cur]);
        if (isOk(sb.toString())) {
          permutation(cur + 1, i);
        }
        sb.deleteCharAt(sb.length() - 1);
      }
    }
  }

  static boolean isOk(String str) {
    StringBuilder tmp;

    int left = 0;
    int right = str.length();

    while (left < right) {
      for (int i = left; i < str.length(); i++) {
        tmp = new StringBuilder();
        for (int j = left; j < i + 1; j++) {
          tmp.append(str.charAt(j));
        }

        if (str.indexOf(tmp.toString(), i) - i == 1) {
          return false;
        }
//        System.out.println(tmp);
      }
      left++;
    }

    return true;
  }

  static boolean isBad(int[] array) {
    List<Integer> list = new ArrayList<>();
    list.add(array[0]);

    for (int i = 1; i < array.length; i++) {
      if (array[i - 1] == array[i]) {
        return true;
      }
    }
    return false;
  }
}