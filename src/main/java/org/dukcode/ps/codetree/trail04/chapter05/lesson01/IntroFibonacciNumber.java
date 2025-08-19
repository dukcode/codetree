package org.dukcode.ps.codetree.trail04.chapter05.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-fibonacci-number/description">LINK</a>
 */
public class IntroFibonacciNumber {

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static int n;
  private static int[] cache;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    bw.write(String.valueOf(fibonacci2(n)));

    br.close();
    bw.close();

  }

  private static int fibonacci(int n) {
    cache = new int[n + 1];
    return fibonacci1(n);
  }

  private static int fibonacci1(int n) {
    if (n <= 2) {
      return 1;
    }

    if (cache[n] != 0) {
      return cache[n];
    }

    return cache[n] = fibonacci(n - 1) + fibonacci(n - 2);
  }

  private static int fibonacci2(int n) {
    int[] dp = new int[n + 1];

    dp[0] = 0;
    dp[1] = 1;

    for (int i = 2; i <= n; ++i) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
  }
}
