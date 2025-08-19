package org.dukcode.ps.codetree.trail04.chapter05.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-maximum-sum-path-in-square/description">LINK</a>
 */
public class IntroMaximumSumPathInSquare {

  private static final int[] DY = {0, 1};
  private static final int[] DX = {1, 0};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[][] board;

  private static int[][] cache;

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

    cache = new int[n][n];
    for (int y = 0; y < n; y++) {
      Arrays.fill(cache[y], -1);
    }

    bw.write(String.valueOf(solve(0, 0)));
//    bw.write(String.valueOf(solve2()));

    br.close();
    bw.close();

  }

  private static int solve(int y, int x) {
    if (y == n - 1 && x == n - 1) {
      return board[y][x];
    }

    if (cache[y][x] != -1) {
      return cache[y][x];
    }

    int ret = 0;
    for (int dir = 0; dir < 2; ++dir) {
      int ny = y + DY[dir];
      int nx = x + DX[dir];

      if (ny >= n || nx >= n) {
        continue;
      }

      ret = Math.max(ret, solve(ny, nx) + board[y][x]);
    }

    return cache[y][x] = ret;
  }

  private static int solve2() {
    int[][] dp = new int[n][n];
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        int upper = y == 0 ? 0 : dp[y - 1][x];
        int left = x == 0 ? 0 : dp[y][x - 1];

        dp[y][x] = board[y][x] + Math.max(upper, left);
      }
    }

    return dp[n - 1][n - 1];
  }
}
