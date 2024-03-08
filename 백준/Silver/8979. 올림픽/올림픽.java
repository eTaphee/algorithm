import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(tokenizer.nextToken());
    int K = Integer.parseInt(tokenizer.nextToken());

//    BoardComparator comparator = new BoardComparator();
    List<Board> boards = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      tokenizer = new StringTokenizer(br.readLine());
      int country = Integer.parseInt(tokenizer.nextToken());
      int gold = Integer.parseInt(tokenizer.nextToken());
      int silver = Integer.parseInt(tokenizer.nextToken());
      int bronze = Integer.parseInt(tokenizer.nextToken());
      boards.add(new Board(country, gold, silver, bronze));
    }

    Collections.sort(boards);

    boards.get(0).setRank(1);
//    Board prevBoard = boards.get(0);
//    Board kboard = boards.get(0);
//
//    for (int i = 1; i < boards.size(); i++) {
//      Board board = boards.get(i);
//
//      if (board.country == K) {
//        kboard = board;
//        if (prevBoard.compareTo(board)  == 0) {
//          board.setRank(prevBoard.getRank());
//        } else {
//          board.setRank(prevBoard.getRank() + 1);
//        }
//        break;
//      }
//
//      // 이전 국가의 메달이 현재 국가의 메달보다 같은 경우
//      if (prevBoard.compareTo(board) == 0) {
//        board.setRank(prevBoard.getRank());
//      } else {
//        board.setRank(prevBoard.getRank() + 1);
//      }
//    }

    int kIdx = 0;

    for (int i = 1; i < boards.size(); i++) {
      Board board = boards.get(i);

      int prevG = boards.get(i - 1).gold;
      int prevS = boards.get(i - 1).silver;
      int prevV = boards.get(i - 1).bronze;

      if (board.country == K) {
        kIdx = i;
      }

      if (board.gold == prevG && board.silver == prevS && board.bronze == prevV) {
        board.setRank(boards.get(i - 1).rank);
      } else {
        board.rank = i + 1;
      }
    }

    System.out.println(boards.get(kIdx).rank);
  }

  static class Board implements Comparable<Board> {

    private final int country;
    private final int gold;
    private final int silver;
    private final int bronze;
    private int rank;

    public Board(int country, int gold, int silver, int bronze) {
      this.country = country;
      this.gold = gold;
      this.silver = silver;
      this.bronze = bronze;
    }

    public void setRank(int rank) {
      this.rank = rank;
    }

    public int getRank() {
      return this.rank;
    }

    @Override
    public String toString() {
      return String.format("country=%d, gold=%d, silver=%d, bronze=%d", country, gold,
          silver, bronze);
    }

    @Override
    public int compareTo(Board o) {
      if (this.gold == o.gold) {
        if (this.silver == o.silver) {
          return o.bronze - this.bronze;
        } else {
          return o.silver - this.silver;
        }
      } else {
        return o.gold - this.gold;
      }
    }
  }

  static class BoardComparator implements Comparator<Board> {

    @Override
    public int compare(Board b1, Board b2) {
      int goldCompare = Integer.compare(b1.gold, b2.gold);
      if (goldCompare != 0) {
        return goldCompare * -1;
      }

      int silverCompare = Integer.compare(b1.silver, b2.silver);
      if (silverCompare != 0) {
        return silverCompare * -1;
      }

      return Integer.compare(b1.bronze, b2.bronze) * -1;
    }
  }
}
