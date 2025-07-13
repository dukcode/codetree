package org.dukcode.ps.codetree.trail04.chapter01.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-best-cross-shape-bomb/description">LINK</a>
 */
public class TestBestCrossShapeBomb {

  private static final int[] DY = {-1, 1, 0, 0};
  private static final int[] DX = {0, 0, -1, 1};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[][] board;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    board = new int[n][n];
    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < n; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());
      }
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();

  }

  private static int solve() {
    int ret = 0;
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        ret = Math.max(ret, boom(y, x));
      }
    }

    return ret;
  }

  private static int boom(int r, int c) {
    int[][] tmpBoard = copyBoard();

    int power = board[r][c];
    for (int dir = 0; dir < 4; ++dir) {
      for (int p = 0; p < power; ++p) {
        int ny = r + DY[dir] * p;
        int nx = c + DX[dir] * p;

        if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
          continue;
        }

        tmpBoard[ny][nx] = 0;
      }
    }

    for (int x = 0; x < n; ++x) {
      dropCol(tmpBoard, x);
    }

    return cntPair(tmpBoard);
  }

  private static int cntPair(int[][] board) {
    int cnt = 0;
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        for (int dir = 0; dir < 4; ++dir) {
          int ny = y + DY[dir];
          int nx = x + DX[dir];

          if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
            continue;
          }

          if (board[y][x] == 0 || board[y][x] != board[ny][nx]) {
            continue;
          }

          cnt++;
        }
      }
    }

    return cnt / 2;
  }

  private static void dropCol(int[][] board, int col) {
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

  private static int[][] copyBoard() {
    int[][] ret = new int[n][n];

    for (int y = 0; y < n; y++) {
      System.arraycopy(board[y], 0, ret[y], 0, n);
    }

    return ret;
  }
}
