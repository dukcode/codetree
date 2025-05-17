package org.dukcode.ps.codetree.trail02.chapter04.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-maximum-overlapped-segments/description">LINK</a>
 */
public class IntroMaximumOverlappedSegments {

  private static final int RANGE = 100;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] lines = new int[2 * RANGE + 1];

    int ans = 0;
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int frIn = Integer.parseInt(st.nextToken());
      int toEx = Integer.parseInt(st.nextToken());

      for (int idx = frIn; idx < toEx; idx++) {
        lines[idx + RANGE]++;
        ans = Math.max(ans, lines[idx + RANGE]);
      }
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }
}
