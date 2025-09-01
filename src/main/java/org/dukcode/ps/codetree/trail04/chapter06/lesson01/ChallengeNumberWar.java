package org.dukcode.ps.codetree.trail04.chapter06.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-number-war/description">LINK</a>
 */
public class ChallengeNumberWar {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] a;
  private static int[] b;

  private static int[][] cache;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    a = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    b = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      b[i] = Integer.parseInt(st.nextToken());
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    cache = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(cache[i], -1);
    }
    return solve(0, 0);
  }

  private static int solve(int idx1, int idx2) {
    if (idx1 == n || idx2 == n) {
      return 0;
    }

    if (cache[idx1][idx2] != -1) {
      return cache[idx1][idx2];
    }

    int ret = solve(idx1 + 1, idx2 + 1);
    if (a[idx1] == b[idx2]) {
      ret = Math.max(ret, solve(idx1 + 1, idx2 + 1));
    } else if (a[idx1] > b[idx2]) {
      ret = Math.max(ret, solve(idx1, idx2 + 1) + b[idx2]);
    } else if (a[idx1] < b[idx2]) {
      ret = Math.max(ret, solve(idx1 + 1, idx2));
    }

    return cache[idx1][idx2] = ret;
  }
}
