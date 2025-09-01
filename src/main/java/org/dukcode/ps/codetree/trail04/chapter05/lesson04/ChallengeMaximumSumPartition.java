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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-maximum-sum-partition/description">LINK</a>
 */
public class ChallengeMaximumSumPartition {

  private static final int MN = -987_654_321;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] arr;
  private static int total;

  private static int[][] cache;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    arr = new int[n];
    total = 0;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      total += arr[i];
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    cache = new int[n][2 * total + 1];

    for (int i = 0; i < n; ++i) {
      Arrays.fill(cache[i], Integer.MIN_VALUE);
    }

    int ret = solve(0, 0, 0);
    return Math.max(solve(0, 0, 0), 0);
  }

  private static int solve(int idx, int a, int b) {
    if (idx == n) {
      return a == b ? 0 : MN; // 0을 반환해야 부분문제에서 결과가 유일결정
    }

    if (cache[idx][a - b + total] != Integer.MIN_VALUE) {
      return cache[idx][a - b + total];
    }

    int ret = solve(idx + 1, a, b);
    ret = Math.max(ret, solve(idx + 1, a + arr[idx], b) + arr[idx]);
    ret = Math.max(ret, solve(idx + 1, a, b + arr[idx]));

    return cache[idx][a - b + total] = ret;
  }
}
