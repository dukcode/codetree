package org.dukcode.ps.codetree.trail04.chapter06.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-longest-common-sequence-2/description">LINK</a>
 */
public class ChallengeLongestCommonSequence2 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static char[] a;
  private static int n;
  private static char[] b;
  private static int m;

  private static int[][] cache;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    a = br.readLine().toCharArray();
    n = a.length;
    b = br.readLine().toCharArray();
    m = b.length;

    bw.write(solve());

    br.close();
    bw.close();

  }

  private static String solve() {
    cache = new int[n][m];
    for (int[] line : cache) {
      Arrays.fill(line, -1);
    }

    return solve(0, 0);
  }

  private static String solve(int aIdx, int bIdx) {
    if (aIdx == n || bIdx == m) {
      return "";
    }

    if (a[aIdx] == b[bIdx] && lcs(aIdx, bIdx) == lcs(aIdx + 1, bIdx + 1) + 1) {
      return a[aIdx] + solve(aIdx + 1, bIdx + 1);
    }

    if (lcs(aIdx, bIdx) == lcs(aIdx, bIdx + 1)) {
      return solve(aIdx, bIdx + 1);
    }

    if (lcs(aIdx, bIdx) == lcs(aIdx + 1, bIdx)) {
      return solve(aIdx + 1, bIdx);
    }

    throw new RuntimeException();
  }

  private static int lcs(int aIdx, int bIdx) {
    if (aIdx == n || bIdx == m) {
      return 0;
    }

    if (cache[aIdx][bIdx] != -1) {
      return cache[aIdx][bIdx];
    }

    int ret = Math.max(lcs(aIdx + 1, bIdx), lcs(aIdx, bIdx + 1));

    if (a[aIdx] == b[bIdx]) {
      ret = Math.max(ret, lcs(aIdx + 1, bIdx + 1) + 1);
    }

    return cache[aIdx][bIdx] = ret;
  }
}
