package org.dukcode.ps.codetree.trail02.chapter05.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-who-will-pay/description">LINK</a>
 */
public class IntroWhoWillPay {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int penalty = -1;
    int[] arr = new int[n];
    for (int i = 0; i < m; ++i) {
      int idx = Integer.parseInt(br.readLine()) - 1;
      arr[idx]++;

      if (arr[idx] == k) {
        penalty = idx + 1;
        break;
      }
    }

    bw.write(String.valueOf(penalty));

    br.close();
    bw.close();

  }
}
