package org.dukcode.ps.codetree.trail05.chapter02.lesson06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-max-interval-without-overlapping-numbers/description">LINK</a>
 */
public class IntroMaxIntervalWithoutOverlappingNumbers {

  private static final int RANGE = 100_000;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] recentIdx;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    recentIdx = new int[RANGE + 1];
    Arrays.fill(recentIdx, -1);

    int ans = 0;

    st = new StringTokenizer(br.readLine());
    int start = 0;
    for (int idx = 0; idx < n; idx++) {
      int num = Integer.parseInt(st.nextToken());

      if (recentIdx[num] != -1) {
        start = Math.max(start, recentIdx[num] + 1);
      }

      ans = Math.max(ans, idx - start + 1);
      recentIdx[num] = idx;
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();
  }
}
