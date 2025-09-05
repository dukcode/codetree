package org.dukcode.ps.codetree.trail04.chapter06.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-shortest-common-supersubsequence/description">LINK</a>
 */
public class TestShortestCommonSupersubsequence {

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static char[] a;
  private static char[] b;

  private static int n;
  private static int m;

  private static int[][] cache;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    a = br.readLine().toCharArray();
    b = br.readLine().toCharArray();

    n = a.length;
    m = b.length;

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    cache = new int[n][m];
    for (int[] row : cache) {
      Arrays.fill(row, -1);
    }

    return solve(0, 0);
  }

  private static int solve(int aIdx, int bIdx) {
    if (aIdx == n) {
      return m - bIdx;
    }

    if (bIdx == m) {
      return n - aIdx;
    }

    if (cache[aIdx][bIdx] != -1) {
      return cache[aIdx][bIdx];
    }

    if (a[aIdx] == b[bIdx]) {
      return cache[aIdx][bIdx] = solve(aIdx + 1, bIdx + 1) + 1;
    }

    return cache[aIdx][bIdx] = Math.min(solve(aIdx + 1, bIdx), solve(aIdx, bIdx + 1)) + 1;
  }
}
