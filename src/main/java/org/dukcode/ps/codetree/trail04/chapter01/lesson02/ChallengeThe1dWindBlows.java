package org.dukcode.ps.codetree.trail04.chapter01.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-The-1D-wind-blows/description">LINK</a>
 */
public class ChallengeThe1dWindBlows {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int h;
  private static int w;
  private static int q;
  private static int[][] board;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    h = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());
    q = Integer.parseInt(st.nextToken());

    board = new int[h][w];
    for (int y = 0; y < h; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < w; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < q; ++i) {
      st = new StringTokenizer(br.readLine());
      int row = Integer.parseInt(st.nextToken()) - 1;
      boolean moveRight = st.nextToken().equals("L");

      blow(row, moveRight, 0);
    }

    for (int y = 0; y < h; y++) {
      for (int x = 0; x < w; x++) {
        bw.write(String.valueOf(board[y][x]));
        bw.write(' ');
      }
      bw.newLine();
    }
    bw.newLine();

    br.close();
    bw.close();
  }

  private static void blow(int row, boolean moveRight, int rowDiff) {
    if (row < 0 || row >= h) {
      return;
    }

    if (moveRight) {
      moveRight(row);
    } else {
      moveLeft(row);
    }

    if (row - 1 >= 0 && rowDiff != 1 && canEffect(row, row - 1)) {
      blow(row - 1, !moveRight, -1);
    }

    if (row + 1 < h && rowDiff != -1 && canEffect(row, row + 1)) {
      blow(row + 1, !moveRight, 1);
    }
  }

  private static void moveRight(int y) {
    int tmp = board[y][w - 1];
    for (int i = w - 1; i > 0; --i) {
      board[y][i] = board[y][i - 1];
    }
    board[y][0] = tmp;
  }

  private static void moveLeft(int y) {
    int tmp = board[y][0];
    for (int i = 0; i < w - 1; ++i) {
      board[y][i] = board[y][i + 1];
    }

    board[y][w - 1] = tmp;
  }

  private static boolean canEffect(int row, int other) {
    for (int i = 0; i < w; i++) {
      if (board[row][i] == board[other][i]) {
        return true;
      }
    }

    return false;
  }
}
