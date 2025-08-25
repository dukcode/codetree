package org.dukcode.ps.codetree.trail04.chapter05.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-increasing-and-descreasing-subsequence/description">LINK</a>
 */
public class ChallengeIncreasingAndDescreasingSubsequence {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] arr;
  private static int[] incCache;
  private static int[] descCache;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    incCache = new int[n];
    descCache = new int[n];

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();

  }

  private static int solve() {
    int ret = -1;
    for (int idx = 0; idx < n; idx++) {
      ret = Math.max(ret, solveInc(idx) + solveDesc(idx) - 1);
    }
    return ret;
  }

  private static int solveInc(int idx) {
    if (incCache[idx] != 0) {
      return incCache[idx];
    }

    int ret = 1;
    for (int beforeIdx = 0; beforeIdx < idx; beforeIdx++) {
      if (arr[beforeIdx] >= arr[idx]) {
        continue;
      }

      ret = Math.max(ret, solveInc(beforeIdx) + 1);
    }

    return incCache[idx] = ret;
  }

  private static int solveDesc(int idx) {
    if (descCache[idx] != 0) {
      return descCache[idx];
    }

    int ret = 1;
    for (int nextIdx = idx + 1; nextIdx < n; nextIdx++) {
      if (arr[nextIdx] >= arr[idx]) {
        continue;
      }

      ret = Math.max(ret, solveDesc(nextIdx) + 1);
    }

    return descCache[idx] = ret;
  }
}
