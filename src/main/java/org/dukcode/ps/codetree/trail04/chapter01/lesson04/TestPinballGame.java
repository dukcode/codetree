package org.dukcode.ps.codetree.trail04.chapter01.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-pinball-game/description">LINK</a>
 */
public class TestPinballGame {

  // 하 좌 상 우
  private static final int[] DY = {1, 0, -1, 0};
  private static final int[] DX = {0, -1, 0, 1};

  private static final int NONE = 0;
  private static final int RIGHT_UPPER = 1;
  private static final int LEFT_LOWER = 2;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[][] board;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    input();
    bw.write(String.valueOf(solve()));
    br.close();
    bw.close();

  }

  private static int solve() {
    int ret = 0;

    for (int i = 0; i < n; ++i) {
      ret = Math.max(ret, start(-1, i, 0));
    }

    for (int i = 0; i < n; ++i) {
      ret = Math.max(ret, start(i, n, 1));
    }

    for (int i = 0; i < n; ++i) {
      ret = Math.max(ret, start(n, i, 2));
    }

    for (int i = 0; i < n; ++i) {
      ret = Math.max(ret, start(i, -1, 3));
    }

    return ret;
  }

  private static int start(int y, int x, int dir) {
    int ret = 0;
    do {
      dir = changeDir(y, x, dir);
      y += DY[dir];
      x += DX[dir];
      ret++;
    } while (inRange(y, x));

    return ret;
  }

  private static int changeDir(int y, int x, int dir) {
    if (!inRange(y, x)) {
      return dir;
    }

    // 하 좌 상 우
    // 좌 하 우 상
    if (board[y][x] == RIGHT_UPPER) {
      if (dir == 0) {
        return 1;
      }

      if (dir == 1) {
        return 0;
      }

      if (dir == 2) {
        return 3;
      }

      if (dir == 3) {
        return 2;
      }
    }

    if (board[y][x] == LEFT_LOWER) {
      if (dir == 0) {
        return 3;
      }

      if (dir == 1) {
        return 2;
      }

      if (dir == 2) {
        return 1;
      }

      if (dir == 3) {
        return 0;
      }
    }

    return dir;
  }

  private static boolean inRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < n;
  }

  private static void input() throws IOException {
    n = Integer.parseInt(br.readLine());

    board = new int[n][n];
    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < n; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());
      }
    }
  }
}
