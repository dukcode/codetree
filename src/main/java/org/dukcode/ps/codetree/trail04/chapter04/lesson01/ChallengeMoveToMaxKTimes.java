package org.dukcode.ps.codetree.trail04.chapter04.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-move-to-max-k-times/description">LINK</a>
 */
public class ChallengeMoveToMaxKTimes {

  private static final int[] DY = {-1, 1, 0, 0};
  private static final int[] DX = {0, 0, -1, 1};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int k;
  private static int[][] board;
  private static int r;
  private static int c;


  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    board = new int[n][n];
    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < n; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());
      }
    }

    st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken()) - 1;
    c = Integer.parseInt(st.nextToken()) - 1;

    bw.write(solve().toString());

    br.close();
    bw.close();

  }

  private static Pos solve() {
    Pos now = new Pos(r, c);
    while (k-- > 0) {
      Pos next = move(now);

      if (next.y == now.y && next.x == now.x) {
        break;
      }

      now = next;
    }

    return now;
  }

  private static Pos move(Pos now) {
    int pivot = board[now.y][now.x];

    boolean[][] discovered = new boolean[n][n];
    Stack<Pos> stk = new Stack<>();
    stk.push(now);
    discovered[now.y][now.x] = true;

    while (!stk.isEmpty()) {
      Pos cur = stk.pop();

      for (int dir = 0; dir < 4; dir++) {
        int ny = cur.y + DY[dir];
        int nx = cur.x + DX[dir];

        if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
          continue;
        }

        if (discovered[ny][nx]) {
          continue;
        }

        if (board[ny][nx] >= pivot) {
          continue;
        }

        discovered[ny][nx] = true;

        stk.push(new Pos(ny, nx));
      }
    }

    int maxVal = 0;
    Pos maxValPos = null;
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        if (y == now.y && x == now.x) {
          continue;
        }
        if (discovered[y][x] && board[y][x] > maxVal) {
          maxVal = board[y][x];
          maxValPos = new Pos(y, x);
        }
      }
    }

    return maxValPos == null ? now : maxValPos;
  }

  private static class Pos {

    int y;
    int x;

    public Pos(int y, int x) {
      this.y = y;
      this.x = x;
    }

    @Override
    public String toString() {
      return (y + 1) + " " + (x + 1);
    }
  }
}
