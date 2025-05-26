package org.dukcode.ps.codetree.trail02.chapter06.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-best-place-of-13-2/description">LINK</a>
 */
public class ChallengeBestPlaceOf132 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[][] board;
  private static int[][] taken;

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

    taken = new int[n][n];

    bw.write(String.valueOf(solve(0, 0)));

    br.close();
    bw.close();

  }

  private static int solve(int cntDraw, int cnt) {
    if (cntDraw == 2) {
      return cnt;
    }

    int ret = 0;
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        int cntBlock = draw(y, x, 1);

        if (cntBlock != -1) {
          ret = Math.max(ret, solve(cntDraw + 1, cnt + cntBlock));
        }

        draw(y, x, -1);
      }
    }

    return ret;
  }

  private static int draw(int y, int x, int delta) {
    int cnt = 0;
    boolean possible = true;
    for (int i = 0; i < 3; ++i) {
      int nx = x + i;

      if (nx >= n) {
        possible = false;
        continue;
      }

      if (taken[y][nx] != 0) {
        possible = false;
      }
      cnt += board[y][nx];
      taken[y][nx] += delta;

    }

    return possible ? cnt : -1;
  }

}
