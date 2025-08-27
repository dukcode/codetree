package org.dukcode.ps.codetree.trail01.chapter08.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-diagonal-numbering/description">LINK</a>
 */
public class ChallengeDiagonalNumbering {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int h;
  private static int w;
  private static int[][] board;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    h = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());

    board = new int[h][w];
    initBoard();

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

  private static void initBoard() {
    int y = 0;
    int x = 0;
    for (int num = 1; num <= h * w; num++) {
      board[y][x] = num;

      int ny = y + 1;
      int nx = x - 1;

      int nextSum = y + x + 1;
      if (ny < 0 || ny >= h || nx < 0 || nx >= w) {
        y = (Math.max(nextSum, w - 1)) - (w - 1);
        x = Math.min(nextSum, w - 1);
      } else {
        y = ny;
        x = nx;
      }
    }
  }
}
