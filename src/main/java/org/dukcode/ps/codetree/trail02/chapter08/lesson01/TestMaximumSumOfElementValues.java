package org.dukcode.ps.codetree.trail02.chapter08.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-maximum-sum-of-element-values/description">LINK</a>
 */
public class TestMaximumSumOfElementValues {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int[] arr;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken()) - 1;
    }

    int ans = 0;
    for (int i = 0; i < n; ++i) {
      ans = Math.max(ans, moveFrom(i));
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

  private static int moveFrom(int idx) {
    int ret = 0;

    int now = idx;
    for (int i = 0; i < m; ++i) {
      ret += arr[now] + 1;
      now = arr[now];
    }

    return ret;
  }
}
