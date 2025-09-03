package org.dukcode.ps.codetree.trail04.chapter06.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-edit-distance/description">LINK</a>
 */
public class ChallengeEditDistance {

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static char[] a;
  private static char[] b;

  private static int[][] cache;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    a = br.readLine().toCharArray();
    b = br.readLine().toCharArray();

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();

  }

  private static int solve() {
    cache = new int[a.length][b.length];
    for (int[] line : cache) {
      Arrays.fill(line, -1);
    }

    return solve(0, 0);
  }

  private static int solve(int aIdx, int bIdx) {
    if (aIdx == a.length) {
      return b.length - bIdx;
    }

    if (bIdx == b.length) {
      return a.length - aIdx;
    }

    if (cache[aIdx][bIdx] != -1) {
      return cache[aIdx][bIdx];
    }

    if (a[aIdx] == b[bIdx]) {
      return cache[aIdx][bIdx] = solve(aIdx + 1, bIdx + 1);
    }

    int delete = solve(aIdx + 1, bIdx) + 1;
    int add = solve(aIdx, bIdx + 1) + 1;
    int change = solve(aIdx + 1, bIdx + 1) + 1;

    return cache[aIdx][bIdx] = Math.min(Math.min(delete, add), change);
  }
}
