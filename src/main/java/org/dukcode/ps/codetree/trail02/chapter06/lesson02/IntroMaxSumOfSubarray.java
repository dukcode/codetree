package org.dukcode.ps.codetree.trail02.chapter06.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-max-sum-of-subarray/description">LINK</a>
 */
public class IntroMaxSumOfSubarray {

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
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int maxSum = Integer.MIN_VALUE;
    for (int start = 0; start <= n - k; ++start) {
      int sum = 0;
      for (int idx = start; idx < start + k; ++idx) {
        sum += arr[idx];
      }

      maxSum = Math.max(maxSum, sum);
    }

    bw.write(String.valueOf(maxSum));

    br.close();
    bw.close();

  }
}
