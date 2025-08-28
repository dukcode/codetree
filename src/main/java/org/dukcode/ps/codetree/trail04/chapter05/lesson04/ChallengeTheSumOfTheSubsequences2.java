package org.dukcode.ps.codetree.trail04.chapter05.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-the-sum-of-the-subsequences/description">LINK</a>
 */
public class ChallengeTheSumOfTheSubsequences2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int[] arr;

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

    bw.write(solve());

    br.close();
    bw.close();
  }

  private static String solve() {
    boolean[] dp = new boolean[m + 1];
    dp[0] = true;

    for (int num : arr) {
      for (int sum = m; sum >= 0; --sum) {
        if (sum - num < 0) {
          continue;
        }

        if (!dp[sum - num]) {
          continue;
        }

        dp[sum] = true;
      }
    }

    return dp[m] ? "Yes" : "No";
  }

}
