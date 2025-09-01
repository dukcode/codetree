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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-climbing-stairs-2/description">LINK</a>
 */
public class IntroClimbingStairs2 {

  private static final int MN = -987_654_321;

  private static final int REMAIN = 3;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] arr;

  private static int[][] cache; // idx에서 x번 기회가 남았을 때 부터 구할 수 있는 최대 동전 수

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    arr = new int[n + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    cache = new int[n + 1][REMAIN + 1];
    for (int i = 0; i < n; i++) {
      Arrays.fill(cache[i], -1);
    }

    int ret = solve(0, REMAIN);
    return ret < 0 ? -1 : ret;
  }

  private static int solve(int idx, int remain) {
    if (idx > n) {
      return MN;
    }

    if (idx == n) {
      return arr[n];
    }

    if (cache[idx][remain] != -1) {
      return cache[idx][remain];
    }

    int ret = solve(idx + 2, remain) + arr[idx];
    if (remain >= 1) {
      ret = Math.max(ret, solve(idx + 1, remain - 1) + arr[idx]);
    }

    return cache[idx][remain] = ret;
  }
}
