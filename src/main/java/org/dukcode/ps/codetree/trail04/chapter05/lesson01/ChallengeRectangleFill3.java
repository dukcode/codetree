package org.dukcode.ps.codetree.trail04.chapter05.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-rectangle-fill-3/description">LINK</a>
 */
public class ChallengeRectangleFill3 {

  private static final int MOD = 1_000_000_007;

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    bw.write(String.valueOf(solve(n)));

    br.close();
    bw.close();

  }

  private static int solve(int n) {
    long[] cache = new long[n + 1];
    return (int) solve(n, cache);
  }

  private static long solve(int n, long[] cache) {
    if (n <= 1) {
      return n + 1;
    }

    if (cache[n] != 0) {
      return cache[n];
    }

    return cache[n] =
        (
            (solve(n - 1, cache) * 3 % MOD)
                + solve(n - 2, cache)
                - solve(n - 3, cache)
                + MOD
        ) % MOD;
  }
}
