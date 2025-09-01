package org.dukcode.ps.codetree.trail04.chapter06.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-surviving-in-a-game-studio/description">LINK</a>
 */
public class ChallengeSurvivingInAGameStudio {

  private static final int MOD = 1_000_000_007;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;

  // 상태 -> 길이가 n일 떄 끝단의 B갯수(0, 1, 2), T의 갯수(0, 1, 2)
  private static int[][][] cache;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    cache = new int[n + 1][3][3];

    int ret = 0;
    for (int b = 0; b <= 2; ++b) {
      for (int t = 0; t <= 2; ++t) {
        ret = (ret + solve(n, b, t)) % MOD;
      }
    }
    return ret;
  }

  private static int solve(int n, int b, int t) {
    if (n == 1) {
      return b + t <= 1 ? 1 : 0;
    }

    if (cache[n][b][t] != 0) {
      return cache[n][b][t];
    }

    int ret = 0;

    if (b == 0) {
      ret = (ret + solve(n - 1, 0, t)) % MOD;
      ret = (ret + solve(n - 1, 1, t)) % MOD;
      ret = (ret + solve(n - 1, 2, t)) % MOD;
    }

    if (b == 1 || b == 2) {
      ret = (ret + solve(n - 1, b - 1, t)) % MOD;
    }

    if (b == 0 && t > 0) {
      ret = (ret + solve(n - 1, 0, t - 1)) % MOD;
      ret = (ret + solve(n - 1, 1, t - 1)) % MOD;
      ret = (ret + solve(n - 1, 2, t - 1)) % MOD;
    }

    return cache[n][b][t] = ret;
  }
}
