package org.dukcode.ps.codetree.trail04.chapter06.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-soccer-and-baseball/description">LINK</a>
 */
public class TestSoccerAndBaseball {

  private static final int MN = -987_654_321;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] s;
  private static int[] b;

  private static int[][][] cache;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    s = new int[n];
    b = new int[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      s[i] = Integer.parseInt(st.nextToken());
      b[i] = Integer.parseInt(st.nextToken());
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    cache = new int[n][11 + 1][9 + 1];
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j <= 11; ++j) {
        Arrays.fill(cache[i][j], -1);
      }
    }

    return solve(0, 11, 9);
  }

  private static int solve(int idx, int cnt1, int cnt2) {
    if (cnt1 == 0 && cnt2 == 0) {
      return 0;
    }

    if (idx == n) {
      return MN;
    }

    if (cache[idx][cnt1][cnt2] != -1) {
      return cache[idx][cnt1][cnt2];
    }

    int ret = solve(idx + 1, cnt1, cnt2);
    if (cnt1 > 0) {
      ret = Math.max(ret, solve(idx + 1, cnt1 - 1, cnt2) + s[idx]);
    }

    if (cnt2 > 0) {
      ret = Math.max(ret, solve(idx + 1, cnt1, cnt2 - 1) + b[idx]);
    }

    return cache[idx][cnt1][cnt2] = ret;
  }
}
