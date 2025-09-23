package org.dukcode.ps.codetree.trail05.chapter02.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-sum-of-n-integers-2/description">LINK</a>
 */
public class IntroSumOfNIntegers2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] pSum = new int[n];
    int ans = Integer.MIN_VALUE;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      pSum[i] = Integer.parseInt(st.nextToken()) + (i == 0 ? 0 : pSum[i - 1]);
      ans = Math.max(ans, pSum[i] - (i - k < 0 ? 0 : pSum[i - k]));
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();
  }
}
