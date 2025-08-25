package org.dukcode.ps.codetree.trail04.chapter05.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-longest-decreasing-subsequence/description">LINK</a>
 */
public class ChallengeLongestDecreasingSubsequence {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] arr;
  private static int[] cache;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();

  }

  private static int solve() {
    cache = new int[n + 1];
    return solve(-1) - 1;
  }

  private static int solve(int idx) {
    if (cache[idx + 1] != 0) {
      return cache[idx + 1];
    }

    int ret = 1;
    int now = idx == -1 ? Integer.MAX_VALUE : arr[idx];
    for (int nextIdx = idx + 1; nextIdx < n; nextIdx++) {
      if (arr[nextIdx] >= now) {
        continue;
      }

      ret = Math.max(ret, solve(nextIdx) + 1);
    }

    return cache[idx + 1] = ret;
  }
}
