package org.dukcode.ps.codetree.trail04.chapter02.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-min-num-of-jumps/description">LINK</a>
 */
public class TestMinNumOfJumps {

  private static final int MX = 987_654_321;

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

    cache = new int[n];
    Arrays.fill(cache, -1);
    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();

  }

  private static int solve() {
    int ret = solve(0);
    return ret == MX ? -1 : ret;
  }

  private static int solve(int idx) {
    if (idx == n - 1) {
      return 0;
    }

    if (cache[idx] != -1) {
      return cache[idx];
    }

    int ret = MX;
    int power = arr[idx];
    for (int nextIdx = idx + 1; nextIdx < Math.min(n, idx + 1 + power); ++nextIdx) {
      ret = Math.min(ret, solve(nextIdx) + 1);
    }

    return cache[idx] = ret;
  }
}
