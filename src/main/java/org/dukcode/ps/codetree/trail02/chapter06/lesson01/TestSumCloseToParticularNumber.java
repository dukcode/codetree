package org.dukcode.ps.codetree.trail02.chapter06.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-sum-close-to-particular-number/description">LINK</a>
 */
public class TestSumCloseToParticularNumber {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int s;

  private static int[] arr;
  private static int totalSum;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    s = Integer.parseInt(st.nextToken());

    arr = new int[n];
    totalSum = 0;

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      totalSum += arr[i];
    }

    int minDiff = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int diff = Math.abs(s - (totalSum - arr[i] - arr[j]));
        if (diff < minDiff) {
          minDiff = diff;
        }
      }
    }

    bw.write(String.valueOf(minDiff));

    br.close();
    bw.close();

  }
}
