package org.dukcode.ps.codetree.trail02.chapter08.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-find-smallest-x/description">LINK</a>
 */
public class IntroFindSmallestX {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] a;
  private static int[] b;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    a = new int[n];
    b = new int[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      a[i] = Integer.parseInt(st.nextToken());
      b[i] = Integer.parseInt(st.nextToken());
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();

  }

  private static int solve() {
    Loop:
    for (int i = a[0] / 2; i <= b[0] / 2; ++i) {

      int num = i;
      for (int idx = 0; idx < n; ++idx) {
        num *= 2;
        if (num < a[idx] || b[idx] < num) {
          continue Loop;
        }
      }

      return i;
    }

    return -1;
  }
}
