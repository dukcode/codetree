package org.dukcode.ps.codetree.trail05.chapter04.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-add-coins/description">LINK</a>
 */
public class IntroAddCoins {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int k;
  private static int[] coins;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    coins = new int[n];
    for (int i = n - 1; i >= 0; i--) {
      coins[i] = Integer.parseInt(br.readLine());
    }

    int totalCnt = 0;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      if (sum == k) {
        break;
      }

      int cnt = (k - sum) / coins[i];

      totalCnt += cnt;
      sum += cnt * coins[i];
    }

    bw.write(String.valueOf(totalCnt));

    br.close();
    bw.close();
  }
}
