package org.dukcode.ps.codetree.trail04.chapter05.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-max-coin-change/description">LINK</a>
 */
public class ChallengeMaxCoinChange {

  private static final int MN = -987_654_321;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int[] coins;

  private static int[][] cache;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    coins = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      coins[i] = Integer.parseInt(st.nextToken());
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    cache = new int[n][m + 1];
    for (int y = 0; y < n; ++y) {
      Arrays.fill(cache[y], -1);
    }

    int ret = solve(0, m);
    return ret == MN ? -1 : ret;
  }

  private static int solve(int idx, int left) {
    if (left == 0) {
      return 0;
    }

    if (idx == n) {
      return MN;
    }

    if (cache[idx][left] != -1) {
      return cache[idx][left];
    }

    int ret = MN;
    for (int cnt = 0; cnt <= left / coins[idx]; ++cnt) {
      int nextCount = solve(idx + 1, left - cnt * coins[idx]);

      if (nextCount == MN) {
        continue;
      }

      ret = Math.max(ret, nextCount + cnt);
    }

    return cache[idx][left] = ret;
  }
}
