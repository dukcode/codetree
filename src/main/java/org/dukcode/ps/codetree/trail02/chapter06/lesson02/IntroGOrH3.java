package org.dukcode.ps.codetree.trail02.chapter06.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-G-or-H-3/description">LINK</a>
 */
public class IntroGOrH3 {

  private static final int RANGE = 10_000;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int k;
  private static int[] scores;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    scores = new int[RANGE];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int idx = Integer.parseInt(st.nextToken()) - 1;
      int score = st.nextToken().equals("G") ? 1 : 2;
      scores[idx] = score;
    }

    int maxSum = 0;
    for (int start = 0; start < RANGE - k; start++) {

      int sum = 0;
      for (int delta = 0; delta <= k; delta++) {
        sum += scores[start + delta];
      }

      maxSum = Math.max(maxSum, sum);
    }

    bw.write(String.valueOf(maxSum));

    br.close();
    bw.close();

  }
}
