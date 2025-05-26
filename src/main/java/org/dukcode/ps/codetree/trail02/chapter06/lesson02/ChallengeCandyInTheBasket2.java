package org.dukcode.ps.codetree.trail02.chapter06.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-candy-in-the-basket-2/description">LINK</a>
 */
public class ChallengeCandyInTheBasket2 {

  private static final int MX_POS = 100;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int k;
  private static int[] candies;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    candies = new int[MX_POS + 1];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken());
      int pos = Integer.parseInt(st.nextToken());

      candies[pos] += num;
    }

    int maxSum = 0;
    for (int c = -k; c <= MX_POS + k; c++) {
      int sum = 0;
      for (int delta = -k; delta <= k; delta++) {
        int pos = c + delta;
        if (pos < 0 || pos > MX_POS) {
          continue;
        }
        sum += candies[c + delta];
      }
      maxSum = Math.max(maxSum, sum);
    }

    bw.write(String.valueOf(maxSum));

    br.close();
    bw.close();

  }
}
