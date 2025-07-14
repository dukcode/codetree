package org.dukcode.ps.codetree.trail04.chapter01.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-falling-horizontal-block/description">LINK</a>
 */
public class ChallengeFallingHorizontalBlock {

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

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken()) - 1;

    board = new int[n][n];
    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < n; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());
      }
    }

    dropBlock(m, k);

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

  private static void dropBlock(int length, int col) {
    int top = findTop(length, col);
    for (int x = col; x < col + length; ++x) {
      board[top][x] = 1;
    }
  }

  private static int findTop(int length, int col) {
    int ret = n - 1;
    for (int x = col; x < col + length; ++x) {
      for (int y = -1; y < n - 1; y++) {
        if (board[y + 1][x] != 0) {
          ret = Math.min(ret, y);
          break;
        }
      }
    }

    return ret;
  }
}
