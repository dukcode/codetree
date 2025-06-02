package org.dukcode.ps.codetree.trail02.chapter07.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-the-grace-form-teacher-2/description">LINK</a>
 */
public class ChallengeTheGraceFormTeacher2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int b;
  private static int[] prices;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());

    prices = new int[n];
    for (int i = 0; i < n; i++) {
      prices[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(prices);

    int ans = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      int sum = 0;
      for (int idx = 0; idx < n; idx++) {
        if (i == idx) {
          sum += prices[idx] / 2;
        } else {
          sum += prices[idx];
        }

        if (sum > b) {
          break;
        }

        ans = Math.max(ans, idx + 1);
      }
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }
}
