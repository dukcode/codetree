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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-the-sum-of-the-subsequences/description">LINK</a>
 */
public class ChallengeTheSumOfTheSubsequences {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int[] arr;

  private static int[][] cache;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    bw.write(solve());

    br.close();
    bw.close();
  }

  private static String solve() {
    cache = new int[n][m + 1];
    for (int y = 0; y < n; ++y) {
      Arrays.fill(cache[y], -1);
    }

    int ret = solve(0, m);
    return ret == 1 ? "Yes" : "No";
  }

  private static int solve(int idx, int left) {
    if (left == 0) {
      return 1;
    }

    if (idx == n || left < 0) {
      return 0;
    }

    if (cache[idx][left] != -1) {
      return cache[idx][left];
    }

    int use = solve(idx + 1, left);
    int notUse = solve(idx + 1, left - arr[idx]);

    return cache[idx][left] = use | notUse;
  }
}
