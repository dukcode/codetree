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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-minimum-diff-partition/description">LINK</a>
 */
public class ChallengeMinimumDiffPartition {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] arr;
  private static int totalSum;

  private static int[][] cache;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    arr = new int[n];
    totalSum = 0;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      totalSum += arr[i];
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();

  }

  private static int solve() {
    cache = new int[n][totalSum + 1];
    for (int i = 0; i < n; i++) {
      Arrays.fill(cache[i], -1);
    }
    return solve(0, 0);
  }

  private static int solve(int idx, int sum) {
    if (idx == n) {
      return Math.abs(totalSum - 2 * sum);
    }

    if (cache[idx][sum] != -1) {
      return cache[idx][sum];
    }

    int ret = Math.min(solve(idx + 1, sum), solve(idx + 1, sum + arr[idx]));
    return cache[idx][sum] = ret;
  }
}
