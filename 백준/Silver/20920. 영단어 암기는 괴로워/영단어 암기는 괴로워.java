import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder note = new StringBuilder();

  static int N, M;

  static Queue<Word> queue = new PriorityQueue<>(
      Comparator.comparingInt((Word w) -> w.count)
          .thenComparingInt(w -> w.value.length())
          .reversed()
          .thenComparing(w -> w.value));

  static Map<String, Integer> map = new HashMap<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    N = Integer.parseInt(tokenizer.nextToken());
    M = Integer.parseInt(tokenizer.nextToken());

    for (int i = 0; i < N; i++) {
      String word = br.readLine();
      if (word.length() >= M) {
        map.put(word, map.getOrDefault(word, 0) + 1);
      }
    }

    for (Entry<String, Integer> entry : map.entrySet()) {
      queue.add(new Word(entry.getKey(), entry.getValue()));
    }

    while (!queue.isEmpty()) {
      note.append(queue.poll().value).append("\n");
    }

    System.out.println(note);
  }

  static class Word {

    String value;
    Integer count;

    Word(String value, Integer count) {
      this.value = value;
      this.count = count;
    }
  }
}
