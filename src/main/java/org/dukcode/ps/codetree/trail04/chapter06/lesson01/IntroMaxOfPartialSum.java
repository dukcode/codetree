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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-max-of-partial-sum/description">LINK</a>
 */
public class IntroMaxOfPartialSum {

  private static final int MN = -987_654_321;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] arr;

  private static int[] cache; // idx에서 시작한 최대 연속 합

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    cache = new int[n];
    Arrays.fill(cache, Integer.MIN_VALUE);

    int ret = MN;
    for (int idx = 0; idx < n; idx++) {
      ret = Math.max(ret, solve(idx));
    }

    return ret;
  }

  private static int solve(int idx) {
    if (idx == n) {
      return 0;
    }

    if (cache[idx] != Integer.MIN_VALUE) {
      return cache[idx];
    }

    return cache[idx] = arr[idx] + Math.max(0, solve(idx + 1));
  }
}
