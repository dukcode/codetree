package org.dukcode.ps.codetree.trail04.chapter05.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-rectangle-fill-2/description">LINK</a>
 */
public class TestRectangleFill2 {

  private static final int MOD = 10_007;

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static int n;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2] * 2) % MOD;
    }

    bw.write(String.valueOf(dp[n]));

    br.close();
    bw.close();

  }
}
