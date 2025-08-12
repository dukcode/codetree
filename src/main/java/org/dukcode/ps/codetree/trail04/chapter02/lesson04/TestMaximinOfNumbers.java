package org.dukcode.ps.codetree.trail04.chapter02.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-maximin-of-numbers/description">LINK</a>
 */
public class TestMaximinOfNumbers {

  private static final int MX = 987_654_321;
  private static final int MN = -987_654_321;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[][] board;

  private static boolean[] taken;

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

    taken = new boolean[n];
    bw.write(String.valueOf(solve(0)));

    br.close();
    bw.close();

  }

  private static int solve(int y) {
    if (y == n) {
      return MX;
    }

    int ret = MN;
    for (int x = 0; x < n; x++) {
      if (taken[x]) {
        continue;
      }

      taken[x] = true;
      ret = Math.max(ret, Math.min(solve(y + 1), board[y][x]));
      taken[x] = false;
    }

    return ret;
  }
}
