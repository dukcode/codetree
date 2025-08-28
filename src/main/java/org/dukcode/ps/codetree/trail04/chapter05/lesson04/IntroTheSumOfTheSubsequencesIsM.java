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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-the-sum-of-the-subsequences-is-m/description">LINK</a>
 */
public class IntroTheSumOfTheSubsequencesIsM {

  private static final int MX = 987_654_321;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int[] arr;

  private static int[] dp;

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

    int ans = solve2();
    bw.write(String.valueOf(ans));

    br.close();
    bw.close();
  }

  private static int solve2() {
    int[][] cache = new int[n][m + 1];
    for (int y = 0; y < n; ++y) {
      Arrays.fill(cache[y], -1);
    }

    int ret = solve(0, m, cache);
    return ret == MX ? -1 : ret;
  }

  private static int solve(int idx, int sum, int[][] cache) {
    if (sum == 0) {
      return 0;
    }

    if (idx == n || sum < 0) {
      return MX;
    }

    if (cache[idx][sum] != -1) {
      return cache[idx][sum];
    }

    int notUse = solve(idx + 1, sum, cache);
    int use = 1 + solve(idx + 1, sum - arr[idx], cache);

    return cache[idx][sum] = Math.min(use, notUse);
  }

  private static int solve1() {
    dp = new int[m + 1];
    Arrays.fill(dp, MX);

    dp[0] = 0;
    for (int idx = 0; idx < n; idx++) {
      for (int sum = m; sum >= 0; --sum) {
        if (sum - arr[idx] < 0) {
          continue;
        }

        if (dp[sum - arr[idx]] == MX) {
          continue;
        }

        dp[sum] = Math.min(dp[sum], dp[sum - arr[idx]] + 1);
      }
    }

    return dp[m] == MX ? -1 : dp[m];
  }
}
