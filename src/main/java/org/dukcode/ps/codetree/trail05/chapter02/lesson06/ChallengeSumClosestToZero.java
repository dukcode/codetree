package org.dukcode.ps.codetree.trail05.chapter02.lesson06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-sum-closest-to-zero/description">LINK</a>
 */
public class ChallengeSumClosestToZero {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] arr;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    int left = 0;
    int right = n - 1;
    int minDiff = Integer.MAX_VALUE;
    while (left < right) {
      minDiff = Math.min(minDiff, Math.abs(arr[left] + arr[right]));

      if (arr[left] + arr[right] > 0) {
        right--;
      } else {
        left++;
      }
    }

    bw.write(String.valueOf(minDiff));

    br.close();
    bw.close();
  }
}
