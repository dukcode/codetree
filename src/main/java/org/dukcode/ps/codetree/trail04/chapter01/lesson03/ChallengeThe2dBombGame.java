package org.dukcode.ps.codetree.trail04.chapter01.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-The-2D-bomb-game/description">LINK</a>
 */
public class ChallengeThe2dBombGame {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int k;
  private static int[][] board;


  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    input();
    int ans = solve();
    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

  private static int solve() {
    for (int i = 0; i < k; ++i) {
      boom();
      rotateClockwise();
      drop();
    }

    boom();

    int ret = 0;
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        if (board[y][x] != 0) {
          ret++;
        }
      }
    }

    return ret;
  }

  private static void boom() {
    for (int x = 0; x < n; ++x) {
      while (true) {
        if (!boomCol(x)) {
          break;
        }
      }
    }
  }

  private static boolean boomCol(int col) {
    boolean boomed = false;
    int cnt = 0;
    int pivot = -1;
    for (int y = 0; y < n; ++y) {
      if (board[y][col] == pivot) {
        cnt++;
        continue;
      }

      if (cnt >= m && pivot != 0) {
        boomed = true;
        clear(y, cnt, col);
      }
      cnt = 1;
      pivot = board[y][col];
    }

    if (cnt >= m && pivot != 0) {
      boomed = true;
      clear(n, cnt, col);
    }

    dropCol(col);

    return boomed;
  }

  private static void clear(int enExRow, int cnt, int col) {
    for (int row = enExRow - 1; row > enExRow - 1 - cnt; --row) {
      board[row][col] = 0;
    }
  }

  private static void swap(int y1, int x1, int y2, int x2) {
    int tmp = board[y1][x1];
    board[y1][x1] = board[y2][x2];
    board[y2][x2] = tmp;
  }

  private static void drop() {
    for (int x = 0; x < n; ++x) {
      dropCol(x);
    }

  }

  private static void dropCol(int col) {
    int pos = n - 1;
    for (int y = n - 1; y >= 0; --y) {
      if (board[y][col] == 0) {
        continue;
      }

      board[pos--][col] = board[y][col];
    }

    while (pos >= 0) {
      board[pos--][col] = 0;
    }
  }

  private static void rotateClockwise() {
    for (int y = 0; y < n; y++) {
      for (int x = y + 1; x < n; x++) {
        swap(y, x, x, y);
      }
    }

    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n / 2; ++x) {
        swap(y, x, y, n - 1 - x);
      }
    }
  }

  private static void input() throws IOException {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    board = new int[n][n];
    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < n; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());
      }
    }
  }
}
