package org.dukcode.ps.codetree.trail05.chapter04.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-max-profit-of-single-car-2/description">LINK</a>
 */
public class ChallengeMaxProfitOfSingleCar2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] prices = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      prices[i] = Integer.parseInt(st.nextToken());
    }

    int ans = 0;
    int minPrice = prices[0];
    for (int i = 1; i < n; ++i) {
      if (prices[i] > minPrice) {
        ans = Math.max(ans, prices[i] - minPrice);
      } else {
        minPrice = Math.min(minPrice, prices[i]);
      }
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();
  }
}
