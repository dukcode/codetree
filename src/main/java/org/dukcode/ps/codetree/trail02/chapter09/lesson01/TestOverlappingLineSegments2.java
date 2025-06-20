package org.dukcode.ps.codetree.trail02.chapter09.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-overlapping-line-segments-2/description">LINK</a>
 */
public class TestOverlappingLineSegments2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] x1;
  private static int[] x2;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    x1 = new int[n];
    x2 = new int[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      x1[i] = Integer.parseInt(st.nextToken());
      x2[i] = Integer.parseInt(st.nextToken());
    }

    bw.write(solve() ? "Yes" : "No");

    br.close();
    bw.close();

  }

  private static boolean solve() {
    for (int exclude = 0; exclude < n; exclude++) {
      int maxX1 = Integer.MIN_VALUE;
      int minX2 = Integer.MAX_VALUE;
      for (int i = 0; i < n; ++i) {
        if (i == exclude) {
          continue;
        }

        maxX1 = Math.max(maxX1, x1[i]);
        minX2 = Math.min(minX2, x2[i]);
      }

      if (minX2 >= maxX1) {
        return true;
      }
    }

    return false;
  }
}
