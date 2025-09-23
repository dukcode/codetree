package org.dukcode.ps.codetree.trail05.chapter02.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-belonging-to-a-rock/description">LINK</a>
 */
public class TestBelongingToARock {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int q;
  private static int[][] pSum;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    q = Integer.parseInt(st.nextToken());

    pSum = new int[3][n];
    for (int i = 0; i < n; i++) {
      int stone = Integer.parseInt(br.readLine()) - 1;

      for (int s = 0; s < 3; ++s) {
        pSum[s][i] = (i == 0 ? 0 : pSum[s][i - 1]) + (s == stone ? 1 : 0);
      }
    }

    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      int frIn = Integer.parseInt(st.nextToken()) - 1;
      int toIn = Integer.parseInt(st.nextToken()) - 1;

      for (int stone = 0; stone < 3; ++stone) {
        bw.write(String.valueOf(cnt(stone, frIn, toIn)));
        bw.write(' ');
      }
      bw.newLine();
    }

    br.close();
    bw.close();
  }

  private static int cnt(int stone, int frIn, int toIn) {
    return pSum[stone][toIn] - (frIn == 0 ? 0 : pSum[stone][frIn - 1]);
  }
}
