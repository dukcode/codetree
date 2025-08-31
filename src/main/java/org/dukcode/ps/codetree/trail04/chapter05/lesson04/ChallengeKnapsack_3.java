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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-knapsack/description">LINK</a>
 */
public class ChallengeKnapsack_3 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int[] weights;
  private static int[] values;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    weights = new int[n];
    values = new int[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      weights[i] = Integer.parseInt(st.nextToken());
      values[i] = Integer.parseInt(st.nextToken());
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    int[] dp = new int[m + 1];
    Arrays.fill(dp, -1);
    dp[0] = 0;

    for (int idx = 0; idx < n; ++idx) {
      for (int w = m; w >= 0; --w) {
        if (w - weights[idx] < 0) {
          continue;
        }

        if (dp[w - weights[idx]] == -1) {
          continue;
        }

        dp[w] = Math.max(dp[w], dp[w - weights[idx]] + values[idx]);
      }
    }

    int ret = 0;
    for (int w = 0; w <= m; ++w) {
      ret = Math.max(ret, dp[w]);
    }

    return ret;
  }
}
