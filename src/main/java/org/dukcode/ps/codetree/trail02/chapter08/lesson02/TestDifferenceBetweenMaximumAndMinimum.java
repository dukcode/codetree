package org.dukcode.ps.codetree.trail02.chapter08.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-difference-between-maximum-and-minimum/description">LINK</a>
 */
public class TestDifferenceBetweenMaximumAndMinimum {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int k;
  private static int[] arr;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      min = Math.min(min, arr[i]);
      max = Math.max(max, arr[i]);
    }

    int ans = Integer.MAX_VALUE;
    for (int frIn = min; frIn <= max - k; ++frIn) {
      int toIn = frIn + k;
      int cost = 0;
      for (int idx = 0; idx < n; ++idx) {
        if (frIn <= arr[idx] && arr[idx] <= toIn) {
          continue;
        }
        cost += Math.min(Math.abs(arr[idx] - frIn), Math.abs(arr[idx] - toIn));
      }

      ans = Math.min(ans, cost);
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }
}
