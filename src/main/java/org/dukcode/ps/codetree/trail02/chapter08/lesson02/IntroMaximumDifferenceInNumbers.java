package org.dukcode.ps.codetree.trail02.chapter08.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-maximum-difference-in-numbers/description">LINK</a>
 */
public class IntroMaximumDifferenceInNumbers {

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
    int minVal = Integer.MAX_VALUE;
    int maxVal = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      minVal = Math.min(minVal, arr[i]);
      maxVal = Math.max(maxVal, arr[i]);
    }

    int ans = Integer.MIN_VALUE;
    for (int frIn = minVal; frIn <= Math.max((maxVal - k), minVal); frIn++) {
      ans = Math.max(ans, cntNumBetween(frIn, frIn + k));
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

  private static int cntNumBetween(int frIn, int toIn) {
    int ret = 0;
    for (int num : arr) {
      if (frIn <= num && num <= toIn) {
        ret++;
      }
    }
    return ret;
  }
}
