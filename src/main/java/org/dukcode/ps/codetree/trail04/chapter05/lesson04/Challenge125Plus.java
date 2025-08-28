package org.dukcode.ps.codetree.trail04.chapter05.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-1-2-5-plus/description">LINK</a>
 */
public class Challenge125Plus {

  private static final int MOD = 10_007;

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static int n;
  private static int[] cache;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    cache = new int[n + 1];
    return solve(n);
  }

  private static int solve(int target) {
    if (target < 0) {
      return 0;
    }

    if (target == 0) {
      return 1;
    }

    if (cache[target] != 0) {
      return cache[target];
    }

    int ret = (solve(target - 1) + solve(target - 2)) % MOD;
    ret = (ret + solve(target - 5)) % MOD;

    return cache[target] = ret;
  }
}
