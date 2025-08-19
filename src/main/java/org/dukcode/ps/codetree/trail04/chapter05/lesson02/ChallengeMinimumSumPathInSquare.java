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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-minimum-sum-path-in-square/description">LINK</a>
 */
public class ChallengeMinimumSumPathInSquare {

  private static final int[] DY = {1, 0};
  private static final int[] DX = {0, -1};

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

    bw.write(String.valueOf(solve(0, n - 1)));

    br.close();
    bw.close();
  }

  private static int solve(int y, int x) {
    if (y == n - 1 && x == 0) {
      return board[y][x];
    }

    if (cache[y][x] != -1) {
      return cache[y][x];
    }

    int ret = Integer.MAX_VALUE;
    for (int dir = 0; dir < 2; ++dir) {
      int ny = y + DY[dir];
      int nx = x + DX[dir];

      if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
        continue;
      }

      ret = Math.min(ret, solve(ny, nx) + board[y][x]);
    }

    return cache[y][x] = ret;
  }
}
