package org.dukcode.ps.codetree.trail04.chapter05.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-knapsack/description">LINK</a>
 */
public class ChallengeKnapsack {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int[] weights;
  private static int[] values;

  private static int[][] cache;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    weights = new int[n];
    values = new int[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      weights[i] = Integer.parseInt(st.nextToken());
      values[i] = Integer.parseInt(st.nextToken());
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    cache = new int[n][m + 1];
    for (int y = 0; y < n; y++) {
      Arrays.fill(cache[y], -1);
    }

    return solve(0, m);
  }

  private static int solve(int idx, int leftWeight) {
    if (idx == n) {
      return 0;
    }

    if (cache[idx][leftWeight] != -1) {
      return cache[idx][leftWeight];
    }

    int ret = solve(idx + 1, leftWeight);
    if (leftWeight - weights[idx] >= 0) {
      ret = Math.max(ret, solve(idx + 1, leftWeight - weights[idx]) + values[idx]);
    }

    return cache[idx][leftWeight] = ret;
  }
}
