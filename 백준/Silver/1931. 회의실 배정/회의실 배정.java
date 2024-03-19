import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static List<Meeting> meetings = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      StringTokenizer tokenizer = new StringTokenizer(br.readLine());
      meetings.add(new Meeting(Integer.parseInt(tokenizer.nextToken()),
          Integer.parseInt(tokenizer.nextToken())));
    }

    Collections.sort(meetings);

    int count = 1;
    Meeting cur = meetings.get(0);
    for (int i = 1; i < N; i++) {
      if (cur.end <= meetings.get(i).start) {
        count++;
        cur = meetings.get(i);
      }
    }

    System.out.println(count);
  }

  static class Meeting implements Comparable<Meeting> {

    int start;
    int end;

    Meeting(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
      int compare = Integer.compare(this.end, o.end);
      if (compare == 0) {
        return Integer.compare(this.start, o.start);
      }
      return compare;
    }

    @Override
    public String toString() {
      return start + " " + end;
    }
  }
}

// 정렬 순서가 중요하다