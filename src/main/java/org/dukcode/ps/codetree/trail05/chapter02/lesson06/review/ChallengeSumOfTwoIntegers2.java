package org.dukcode.ps.codetree.trail05.chapter02.lesson06.review;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-sum-of-two-integers-2/description">LINK</a>
 */
public class ChallengeSumOfTwoIntegers2 {

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
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(arr);

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static long solve() {
    long ret = 0;
    int right = n - 1;
    for (int left = 0; left < n && arr[left] < k; left++) {
      while (left < right && arr[left] + arr[right] > k) {
        right--;
      }

      if (left == right) {
        break;
      }

      ret += right - left;
    }

    return ret;
  }

}
