package org.dukcode.ps.codetree.trail04.chapter06.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-explore-temple-3/description">LINK</a>
 */
public class TestExploreTemple3 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int[][] board;

  private static int[][] cache;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    board = new int[n][m];
    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < m; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());
      }
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    cache = new int[n][m + 1];
    for (int i = 0; i < n; i++) {
      Arrays.fill(cache[i], -1);
    }

    return solve(0, -1);
  }

  private static int solve(int idx, int before) {
    if (idx == n) {
      return 0;
    }

    if (cache[idx][before + 1] != -1) {
      return cache[idx][before + 1];
    }

    int ret = 0;
    for (int now = 0; now < m; now++) {
      if (before == now) {
        continue;
      }
      ret = Math.max(ret, solve(idx + 1, now) + board[idx][now]);
    }

    return cache[idx][before + 1] = ret;
  }
}
