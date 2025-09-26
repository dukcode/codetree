package org.dukcode.ps.codetree.trail05.chapter02.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-section-with-maximum-overlap/description">LINK</a>
 */
public class IntroSectionWithMaximumOverlap {

  private static final int RANGE = 200_000;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] cnt;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    cnt = new int[RANGE + 1];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());

      cnt[x1]++;
      cnt[x2]--;
    }

    int ans = 0;
    int overlap = 0;
    for (int i = 0; i < RANGE; i++) {
      overlap += cnt[i];
      ans = Math.max(ans, overlap);
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();
  }
}
