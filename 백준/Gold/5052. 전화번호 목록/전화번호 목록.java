import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

  static Node telBook;
  static boolean flag;

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      telBook = new Node();
      int n = Integer.parseInt(br.readLine());
      List<String> tels = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        tels.add(br.readLine().replace(" ", ""));
      }

      tels.sort(Comparator.comparingInt(String::length));

      for (String tel : tels) {
        flag = false;
        add(telBook, tel, 0);
        if (flag) {
          break;
        }
      }

      sb.append(flag ? "NO" : "YES").append("\n");
    }

    System.out.println(sb);
  }

  static void add(Node parent, String tel, int idx) {
    if (idx == tel.length()) {
      return;
    }

    char num = tel.charAt(idx);

    Node node = null;
    if (parent.nodes.containsKey(num)) {
      node = parent.nodes.get(num);
    }

    if (node == null) {
      node = new Node();
      node.value = num;
      parent.nodes.put(num, node);
      if (parent.end) {
        flag = true;
      }
    }

    if (idx == tel.length() - 1) {
      node.end = true;
    }

    add(node, tel, idx + 1);
  }

  static class Node {

    char value;
    Map<Character, Node> nodes = new HashMap<>();
    boolean end;
  }
}

// 10%