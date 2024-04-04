import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<Character> list = new LinkedList<>();
    for (char ch : br.readLine().toCharArray()) {
      list.add(ch);
    }

    ListIterator<Character> iterator = list.listIterator(list.size());

    int M = Integer.parseInt(br.readLine());
    for (int i = 0; i < M; i++) {
      String command = br.readLine();
      char c = command.charAt(0);
      switch (c) {
        case 'P':
          iterator.add(command.charAt(2));
          break;
        case 'L':
          if (iterator.hasPrevious()) {
            iterator.previous();
          }
          break;
        case 'D':
          if (iterator.hasNext()) {
            iterator.next();
          }
          break;
        case 'B':
          if (iterator.hasPrevious()) {
            iterator.previous();
            iterator.remove();
          }
          break;
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (Character character : list) {
      bw.write(character);
    }
    bw.flush();
    bw.close();
  }
}
