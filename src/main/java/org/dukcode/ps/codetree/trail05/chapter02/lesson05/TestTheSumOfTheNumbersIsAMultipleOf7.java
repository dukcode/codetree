package org.dukcode.ps.codetree.trail05.chapter02.lesson05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-the-sum-of-the-numbers-is-a-multiple-of-7/description">LINK</a>
 */
public class TestTheSumOfTheNumbersIsAMultipleOf7 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] arr;
  private static int[] minIdx;
  private static int[] maxIdx;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    arr = new int[n];

    minIdx = new int[7];
    Arrays.fill(minIdx, Integer.MAX_VALUE);
    minIdx[0] = -1;

    maxIdx = new int[7];
    Arrays.fill(maxIdx, Integer.MIN_VALUE);
    maxIdx[0] = -1;

    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(br.readLine());
      arr[i] = ((i == 0 ? 0 : arr[i - 1]) + num % 7) % 7;

      minIdx[arr[i]] = Math.min(minIdx[arr[i]], i);
      maxIdx[arr[i]] = Math.max(maxIdx[arr[i]], i);
    }

    int ans = 0;
    for (int i = 0; i < 7; i++) {
      if (minIdx[i] == Integer.MAX_VALUE || maxIdx[i] == Integer.MIN_VALUE) {
        continue;
      }
      ans = Math.max(ans, maxIdx[i] - minIdx[i]);
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();
  }
}
