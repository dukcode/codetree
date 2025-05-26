package org.dukcode.ps.codetree.trail02.chapter06.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-elemental-mean-value-for-a-particular-interval/description">LINK</a>
 */
public class IntroElementalMeanValueForAParticularInterval {

  private static final int MX_NUM = 1000;

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

    int cnt = 0;
    for (int frIn = 0; frIn < n; frIn++) {
      int[] freq = new int[MX_NUM + 1];
      int sum = 0;
      for (int toIn = frIn; toIn < n; toIn++) {
        freq[arr[toIn]]++;
        sum += arr[toIn];
        int avg = sum % (toIn - frIn + 1) != 0 ? -1 : sum / (toIn - frIn + 1);

        if (avg != -1 && freq[avg] != 0) {
          cnt++;
        }
      }
    }

    bw.write(String.valueOf(cnt));

    br.close();
    bw.close();

  }
}
