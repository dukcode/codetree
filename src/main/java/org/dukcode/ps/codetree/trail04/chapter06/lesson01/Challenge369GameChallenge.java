package org.dukcode.ps.codetree.trail04.chapter06.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-369-game-challenge/description">LINK</a>
 */
public class Challenge369GameChallenge {

  private static final int MOD = 1_000_000_007;

  private static final int FALSE = 0;
  private static final int TRUE = 1;

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static char[] n;
  private static int len;
  private static long[][][] cache; // dp[index][remainder][isFree]


  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = br.readLine().toCharArray();
    len = n.length;

    bw.write(String.valueOf(solve()));

    bw.close();
    br.close();
  }

  private static long solve() {
    cache = new long[len][3][2];
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < 3; j++) {
        Arrays.fill(cache[i][j], -1);
      }
    }

    long nonClapCount = solve(0, 0, FALSE);

    long total = 0;
    for (char c : n) {
      total = (total * 10 + (c - '0')) % MOD;
    }

    return (total - nonClapCount + MOD) % MOD;
  }

  public static long solve(int index, int remainder, int isFree) {
    if (index == len) {
      return remainder == 0 ? 0 : 1;
    }

    if (cache[index][remainder][isFree] != -1) {
      return cache[index][remainder][isFree];
    }

    long ret = 0;
    int upperBound = isFree == TRUE ? 9 : (n[index] - '0');

    for (int digit = 0; digit <= upperBound; digit++) {
      if (digit == 3 || digit == 6 || digit == 9) {
        continue;
      }

      int nextRemainder = (remainder + digit) % 3;
      int nextIsFree = isFree | ((digit < upperBound) ? TRUE : FALSE);

      ret = (ret + solve(index + 1, nextRemainder, nextIsFree)) % MOD;
    }

    return cache[index][remainder][isFree] = ret;
  }
}
