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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-select-m-sections/description">LINK</a>
 */
public class ChallengeSelectMSections {

  private static final int MN = -987_654_321;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int[] arr;
  private static int[] psum; // psum[i] = arr[0, i]

  private static int[][] cache;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[n];
    psum = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      psum[i] = (i == 0 ? 0 : psum[i - 1]) + arr[i];
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();

  }

  private static int sum(int frIn, int toIn) {
    return psum[toIn] - (frIn == 0 ? 0 : psum[frIn - 1]);
  }

  private static int solve() {
    cache = new int[n][m + 1];
    for (int i = 0; i < n; i++) {
      Arrays.fill(cache[i], Integer.MAX_VALUE);
    }

    return solve(0, m);
  }

  private static int solve(int frIn, int m) {
    if (m == 0) {
      return 0;
    }

    if (frIn >= n || (n - frIn) < (2 * m - 1)) {
      return MN;
    }

    if (cache[frIn][m] != Integer.MAX_VALUE) {
      return cache[frIn][m];
    }

    int ret = solve(frIn + 1, m);
    for (int toIn = frIn; toIn < n; toIn++) {
      ret = Math.max(ret, solve(toIn + 2, m - 1) + sum(frIn, toIn));
    }

    return cache[frIn][m] = ret;
  }
}
