package org.dukcode.ps.codetree.trail02.chapter06.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-equalizing-the-height-of-the-field/description">LINK</a>
 */
public class TestEqualizingTheHeightOfTheField {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int h;
  private static int t;

  private static int[] pSum; // pSum[i] = 0 ~ (i - 1)까지의 합

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());
    t = Integer.parseInt(st.nextToken());

    pSum = new int[n + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int height = Integer.parseInt(st.nextToken());
      pSum[i + 1] = pSum[i] + Math.abs(height - h);
    }

    int ans = Integer.MAX_VALUE;
    for (int frIn = 0; frIn <= n - t; frIn++) {
      int toEx = frIn + t;
      ans = Math.min(ans, sum(frIn, toEx));
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

  private static int sum(int frIn, int toEx) {
    return pSum[toEx] - pSum[frIn];
  }
}
