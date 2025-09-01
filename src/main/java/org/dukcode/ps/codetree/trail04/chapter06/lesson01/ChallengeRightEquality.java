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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-right-equality/description">LINK</a>
 */
public class ChallengeRightEquality {

  private static final int RANGE = 20;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int[] arr;

  private static long[][] cache; // idx까지 계산했을 때 결과가 m이 되는 가짓수

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static long solve() {
    cache = new long[n][RANGE * 2 + 1];
    for (int i = 0; i < n; ++i) {
      Arrays.fill(cache[i], Long.MAX_VALUE);
    }

    long ret = solve(n - 1, m);
    return ret < 0 ? 0 : ret;
  }

  private static long solve(int idx, int m) {
    if (idx == 0) {
      if (arr[idx] == Math.abs(m)) {
        return m == 0 ? 2 : 1;
      }

      return 0;
    }

    if (cache[idx][m + RANGE] != Long.MAX_VALUE) {
      return cache[idx][m + RANGE];
    }

    long ret = 0;
    if (m + arr[idx] <= 20) {
      ret += solve(idx - 1, m + arr[idx]);
    }

    if (m - arr[idx] >= -20) {
      ret += solve(idx - 1, m - arr[idx]);
    }

    return cache[idx][m + RANGE] = ret;
  }
}
