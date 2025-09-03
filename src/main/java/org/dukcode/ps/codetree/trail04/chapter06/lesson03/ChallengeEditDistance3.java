package org.dukcode.ps.codetree.trail04.chapter06.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-edit-distance-3/description">LINK</a>
 */
public class ChallengeEditDistance3 {

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

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    cache = new int[n][m];
    for (int[] line : cache) {
      Arrays.fill(line, -1);
    }

    return solve(0, 0);
  }

  private static int solve(int aIdx, int bIdx) {
    if (bIdx == m) {
      return n - aIdx; // 삭제
    }

    if (aIdx == n) {
      return m - bIdx; // 삽입
    }

    if (cache[aIdx][bIdx] != -1) {
      return cache[aIdx][bIdx];
    }

    if (a[aIdx] == b[bIdx]) {
      return cache[aIdx][bIdx] = solve(aIdx + 1, bIdx + 1);
    }

    int delete = solve(aIdx + 1, bIdx) + 1;
    int insert = solve(aIdx, bIdx + 1) + 1;

    return cache[aIdx][bIdx] = Math.min(delete, insert);
  }
}

