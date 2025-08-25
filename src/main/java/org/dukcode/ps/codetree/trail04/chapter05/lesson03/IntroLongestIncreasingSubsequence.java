package org.dukcode.ps.codetree.trail04.chapter05.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-longest-increasing-subsequence/description">LINK</a>
 */
public class IntroLongestIncreasingSubsequence {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;


  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    bw.write(String.valueOf(lis(arr, n)));

    br.close();
    bw.close();
  }

  private static int lis(int[] arr, int n) {
    int[] cache = new int[n + 1];
    return lis(arr, n, -1, cache) - 1;
  }

  private static int lis(int[] arr, int n, int idx, int[] cache) {
    if (cache[idx + 1] != 0) {
      return cache[idx + 1];
    }

    int ret = 1;
    int value = idx == -1 ? 0 : arr[idx];
    for (int nextIdx = idx + 1; nextIdx < n; nextIdx++) {
      if (arr[nextIdx] <= value) {
        continue;
      }

      ret = Math.max(ret, lis(arr, n, nextIdx, cache) + 1);
    }

    return cache[idx + 1] = ret;
  }
}
