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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-choose-one-of-two-points/description">LINK</a>
 */
public class ChallengeChooseOneOfTwoPoints {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] reds;
  private static int[] blues;

  private static int[][][] cache;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    reds = new int[2 * n];
    blues = new int[2 * n];
    for (int i = 0; i < 2 * n; i++) {
      st = new StringTokenizer(br.readLine());
      reds[i] = Integer.parseInt(st.nextToken());
      blues[i] = Integer.parseInt(st.nextToken());
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    cache = new int[2 * n][n + 1][n + 1];
    for (int i = 0; i < 2 * n; i++) {
      for (int r = 0; r <= n; r++) {
        Arrays.fill(cache[i][r], -1);
      }
    }

    return solve(0, n, n);
  }

  private static int solve(int idx, int r, int b) {
    if (idx == 2 * n) {
      return 0;
    }

    if (cache[idx][r][b] != -1) {
      return cache[idx][r][b];
    }

    int ret = Integer.MIN_VALUE;

    if (r > 0) {
      ret = Math.max(ret, solve(idx + 1, r - 1, b) + reds[idx]);
    }

    if (b > 0) {
      ret = Math.max(ret, solve(idx + 1, r, b - 1) + blues[idx]);
    }

    return cache[idx][r][b] = ret;
  }
}
