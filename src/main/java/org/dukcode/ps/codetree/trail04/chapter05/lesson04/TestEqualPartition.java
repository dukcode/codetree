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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-equal-partition/description">LINK</a>
 */
public class TestEqualPartition {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] arr;
  private static int total;

  private static int[][] cache; // idx부터 고를 때 diff(a - b)를 0으로 만들 수 있는가?

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      total += arr[i];
    }

    bw.write(solve());

    br.close();
    bw.close();

  }

  private static String solve() {
    cache = new int[n][2 * total + 1];
    for (int i = 0; i < n; i++) {
      Arrays.fill(cache[i], -1);
    }

    return solve(0, 0) == 1 ? "Yes" : "No";
  }

  private static int solve(int idx, int diff) {
    if (idx == n) {
      return diff == 0 ? 1 : 0;
    }

    if (cache[idx][diff + total] != -1) {
      return cache[idx][diff + total];
    }

    return cache[idx][diff + total] = (solve(idx + 1, diff + arr[idx]) | solve(idx + 1,
        diff - arr[idx]));
  }
}
