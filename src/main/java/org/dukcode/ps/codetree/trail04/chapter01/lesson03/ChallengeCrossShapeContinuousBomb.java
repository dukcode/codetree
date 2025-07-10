package org.dukcode.ps.codetree.trail04.chapter01.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-cross-shape-continuous-bomb/description">LINK</a>
 */
public class ChallengeCrossShapeContinuousBomb {

  private static final int[] DY = {-1, 1, 0, 0};
  private static final int[] DX = {0, 0, -1, 1};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int[][] board;
  private static int[] commands;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    input();
    solve();
    print();

    br.close();
    bw.close();

  }

  private static void solve() {
    for (int col : commands) {
      boom(col);
    }
  }

  private static void boom(int col) {
    int row = findRow(col);

    if (row == -1) {
      return;
    }

    boom(row, col);

    drop();
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

  private static void boom(int row, int col) {
    int power = board[row][col];
    for (int p = 0; p < power; ++p) {
      for (int dir = 0; dir < 4; ++dir) {
        int ny = row + DY[dir] * p;
        int nx = col + DX[dir] * p;

        if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
          continue;
        }

        board[ny][nx] = 0;
      }
    }
  }

  private static int findRow(int col) {
    for (int row = 0; row < n; ++row) {
      if (board[row][col] != 0) {
        return row;
      }
    }

    return -1;
  }


  private static void print() throws IOException {
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        bw.write(String.valueOf(board[y][x]));
        bw.write(' ');
      }
      bw.newLine();
    }
  }

  private static void input() throws IOException {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    board = new int[n][n];
    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < n; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());
      }
    }

    commands = new int[m];
    for (int i = 0; i < m; i++) {
      commands[i] = Integer.parseInt(br.readLine()) - 1;
    }
  }
}
