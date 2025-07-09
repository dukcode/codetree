package org.dukcode.ps.codetree.trail04.chapter01.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-cross-shape-bomb/description">LINK</a>
 */
public class ChallengeCrossShapeBomb {

  private static final int[] DY = {0, 0, -1, 1};
  private static final int[] DX = {-1, 1, 0, 0};

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

    st = new StringTokenizer(br.readLine());
    int by = Integer.parseInt(st.nextToken()) - 1;
    int bx = Integer.parseInt(st.nextToken()) - 1;

    boom(by, bx);
    drop();

    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        bw.write(String.valueOf(board[y][x]));
        bw.write(' ');
      }
      bw.newLine();
    }

    br.close();
    bw.close();

  }

  private static void drop() {
    for (int x = 0; x < n; x++) {
      dropCol(x);
    }
  }

  private static void dropCol(int x) {
    int idx = n - 1;
    for (int i = n - 1; i >= 0; i--) {
      if (board[i][x] == 0) {
        continue;
      }

      board[idx--][x] = board[i][x];
    }

    while (idx >= 0) {
      board[idx--][x] = 0;
    }
  }

  private static void boom(int by, int bx) {
    int power = board[by][bx];
    board[by][bx] = 0;
    for (int dir = 0; dir < 4; dir++) {
      for (int i = 1; i < power; ++i) {
        int ny = by + DY[dir] * i;
        int nx = bx + DX[dir] * i;

        if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
          continue;
        }

        board[ny][nx] = 0;
      }
    }
  }
}
