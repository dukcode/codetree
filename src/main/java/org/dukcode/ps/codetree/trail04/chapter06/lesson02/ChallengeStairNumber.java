package org.dukcode.ps.codetree.trail04.chapter06.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-stair-number/description">LINK</a>
 */
public class ChallengeStairNumber {

  private static final int MOD = 1_000_000_007;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[][] cache; //

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
    n = Integer.parseInt(br.readLine());

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    cache = new int[n + 1][10];
    for (int len = 0; len <= n; len++) {
      Arrays.fill(cache[len], -1);
    }

    int ret = 0;
    for (int digit = 0; digit <= 9; digit++) {
      ret = (ret + solve(n, digit)) % MOD;
    }
    return ret;
  }

  private static int solve(int len, int digit) {
    if (len == 1) {
      return digit == 0 ? 0 : 1;
    }

    if (cache[len][digit] != -1) {
      return cache[len][digit];
    }

    int ret = 0;
    if (digit != 0) {
      ret = (ret + solve(len - 1, digit - 1)) % MOD;
    }

    if (digit != 9) {
      ret = (ret + solve(len - 1, digit + 1)) % MOD;
    }

    return cache[len][digit] = ret;
  }
}
