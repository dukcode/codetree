package org.dukcode.ps.codetree.trail02.chapter01.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-sum-of-specific-intervals/description">LINK</a>
 */
public class TestSumOfSpecificIntervals {

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
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int frIn = Integer.parseInt(st.nextToken()) - 1;
      int toIn = Integer.parseInt(st.nextToken()) - 1;

      bw.write(String.valueOf(sumOfSubArray(arr, frIn, toIn)));
      bw.newLine();
    }

    br.close();
    bw.close();

  }

  private static int sumOfSubArray(int[] arr, int frIn, int toIn) {
    int ret = 0;
    for (int i = frIn; i <= toIn; ++i) {
      ret += arr[i];
    }

    return ret;
  }
}
