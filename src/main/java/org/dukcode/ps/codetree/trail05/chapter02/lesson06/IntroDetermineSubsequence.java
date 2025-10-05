package org.dukcode.ps.codetree.trail05.chapter02.lesson06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-determine-subsequence/description">LINK</a>
 */
public class IntroDetermineSubsequence {

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

    a = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    b = new int[m];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      b[i] = Integer.parseInt(st.nextToken());
    }

    bw.write(solve() ? "Yes" : "No");

    br.close();
    bw.close();
  }

  private static boolean solve() {
    int bIdx = 0;
    for (int aIdx = 0; aIdx < n; aIdx++) {
      if (a[aIdx] == b[bIdx]) {
        bIdx++;
      }

      if (bIdx == m) {
        return true;
      }
    }

    return false;
  }
}
