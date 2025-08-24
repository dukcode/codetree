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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-minimum-difference-on-the-integer-grid-2/description">LINK</a>
 */
public class ChallengeMinimumDifferenceOnTheIntegerGrid2 {

  private static final int[] DY = {0, 1};
  private static final int[] DX = {1, 0};

  private static final int MX = Integer.MAX_VALUE;
  private static final int MAX_VAL = 100;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[][] board;

  private static int[][][] cache; // [y][x][minVal] = maxVal
  private static boolean[][] calculated;

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


  public static int solve() {
    cache = new int[n][n][MAX_VAL + 1];

    for (int z = 0; z < n; z++) {
      for (int y = 0; y < n; y++) {
        Arrays.fill(cache[z][y], MX);
      }
    }

    calculated = new boolean[n][n];

    int[] results = solve(0, 0);

    int ret = MX;
    for (int min = 1; min <= MAX_VAL; min++) {
      int max = results[min];

      if (max == MX) {
        continue;
      }

      ret = Math.min(ret, max - min);
    }

    return ret;
  }

  private static int[] solve(int y, int x) {
    if (calculated[y][x]) {
      return cache[y][x];
    }

    if (y == n - 1 && x == n - 1) {
      int value = board[n - 1][n - 1];
      cache[y][x][value] = value;
      return cache[y][x];
    }

    for (int dir = 0; dir < 2; dir++) {
      int ny = y + DY[dir];
      int nx = x + DX[dir];

      if (ny >= n || nx >= n) {
        continue;
      }

      int[] nextResults = solve(ny, nx);

      int value = board[y][x];
      for (int nextMin = 1; nextMin <= MAX_VAL; nextMin++) {
        int nextMax = nextResults[nextMin];

        if (nextMax == MX) {
          continue;
        }

        int newMin = Math.min(value, nextMin);
        int newMax = Math.max(value, nextMax);
        cache[y][x][newMin] = Math.min(cache[y][x][newMin], newMax);
      }
    }

    calculated[y][x] = true;
    return cache[y][x];
  }
}
