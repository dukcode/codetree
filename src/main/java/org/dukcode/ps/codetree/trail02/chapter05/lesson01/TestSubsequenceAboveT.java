package org.dukcode.ps.codetree.trail02.chapter05.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-subsequence-above-t/description">LINK</a>
 */
public class TestSubsequenceAboveT {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int t = Integer.parseInt(st.nextToken());

    int cnt = 0;
    int maxCnt = 0;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(st.nextToken());

      if (num <= t) {
        cnt = 0;
        continue;
      }

      cnt++;
      maxCnt = Math.max(maxCnt, cnt);
    }

    bw.write(String.valueOf(maxCnt));

    br.close();
    bw.close();

  }
}
