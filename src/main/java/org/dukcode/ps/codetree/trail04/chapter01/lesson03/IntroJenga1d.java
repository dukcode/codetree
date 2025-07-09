package org.dukcode.ps.codetree.trail04.chapter01.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-jenga-1d/description">LINK</a>
 */
public class IntroJenga1d {

  private static final int N = 2;

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
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    int lastIdx = n;
    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      int frIn = Integer.parseInt(st.nextToken()) - 1;
      int toIn = Integer.parseInt(st.nextToken()) - 1;

      lastIdx = remove(frIn, toIn, lastIdx);
    }

    bw.write(String.valueOf(lastIdx));
    bw.newLine();
    for (int i = 0; i < lastIdx; i++) {
      bw.write(String.valueOf(arr[i]));
      bw.newLine();
    }

    br.close();
    bw.close();

  }

  private static int remove(int frIn, int toIn, int lastIdx) {
    int idx = 0;
    for (int i = 0; i < lastIdx; ++i) {
      if (frIn <= i && i <= toIn) {
        continue;
      }

      arr[idx++] = arr[i];
    }

    return idx;
  }
}
