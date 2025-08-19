package org.dukcode.ps.codetree.trail04.chapter05.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-rectangle-fill/description">LINK</a>
 */
public class ChallengeRectangleFill {

  private static final int MOD = 10_007;

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static int n;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    bw.write(String.valueOf(solve(n)));

    br.close();
    bw.close();

  }

  private static int solve(int n) {
//    int[] cache = new int[n + 1];
//    return solveTopDown(n, cache);
    return solveBottomUp(n);
  }

  private static int solveTopDown(int n, int[] cache) {
    if (n <= 2) {
      return cache[n] = n;
    }

    if (cache[n] != 0) {
      return cache[n];
    }

    return cache[n] = (solveTopDown(n - 1, cache) + solveTopDown(n - 2, cache)) % MOD;
  }

  private static int solveBottomUp(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= n; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
    }

    return dp[n];
  }
}
