import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Main {

  static Map<Character, Integer> map = new HashMap<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();

    char[] charArray = str.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
      if (charArray[i] >= 'a' && charArray[i] <= 'z') {
        charArray[i] -= 32;
      }

      map.put(charArray[i], map.getOrDefault(charArray[i], 0) + 1);
    }

    List<Entry<Character, Integer>> collect = map.entrySet().stream()
        .sorted((c1, c2) -> Integer.compare(c1.getValue(), c2.getValue()) * -1)
        .collect(Collectors.toList());

    if (collect.size() == 1) {
      System.out.println(collect.get(0).getKey());
      return;
    }

    if (collect.get(0).getValue().equals(collect.get(1).getValue())) {
      System.out.println("?");
      return;
    }

    System.out.println(collect.get(0).getKey());
  }
}
