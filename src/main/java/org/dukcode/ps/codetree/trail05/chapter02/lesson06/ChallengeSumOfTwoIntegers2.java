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
    long cnt = 0;
    int j = n - 1;
    for (int i = 0; i < n - 1; ++i) {
      while (arr[i] + arr[j] > k && i + 1 < j) {
        j--;
      }

      if (arr[i] + arr[j] <= k) {
        cnt += j - i;
      }
    }
    return cnt;
  }

  private static long solve2() {
    long cnt = 0;
    int left = 0;
    int right = n - 1;

    while (left < right) {
      if (arr[left] + arr[right] <= k) {
        cnt += (right - left);
        left++;
      } else {
        right--;
      }
    }

    return cnt;
  }

}
