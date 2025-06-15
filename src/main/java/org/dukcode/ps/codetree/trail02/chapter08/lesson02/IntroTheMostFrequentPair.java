package org.dukcode.ps.codetree.trail02.chapter08.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-the-most-frequent-pair/description">LINK</a>
 */
public class IntroTheMostFrequentPair {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  private static int[] a;
  private static int[] b;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    a = new int[m];
    b = new int[m];
    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      a[i] = Integer.parseInt(st.nextToken());
      b[i] = Integer.parseInt(st.nextToken());
    }

    int ans = 0;
    for (int fr = 1; fr < n; ++fr) {
      for (int to = fr + 1; to <= n; ++to) {
        ans = Math.max(ans, cntPair(fr, to));
      }
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

  private static int cntPair(int fr, int to) {
    int ret = 0;
    for (int i = 0; i < m; ++i) {
      if ((fr == a[i] && to == b[i]) || (fr == b[i] && to == a[i])) {
        ret++;
      }
    }

    return ret;
  }
}
