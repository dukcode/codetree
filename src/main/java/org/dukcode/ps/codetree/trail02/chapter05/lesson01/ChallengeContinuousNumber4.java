package org.dukcode.ps.codetree.trail02.chapter05.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-continuous-number4/description">LINK</a>
 */
public class ChallengeContinuousNumber4 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    int before = 0;
    int cnt = 0;
    int maxCnt = 0;
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(br.readLine());

      if (before >= num) {
        maxCnt = Math.max(maxCnt, cnt);
        before = num;
        cnt = 1;
        continue;
      }

      before = num;
      cnt++;
    }

    maxCnt = Math.max(maxCnt, cnt);

    bw.write(String.valueOf(maxCnt));

    br.close();
    bw.close();

  }
}
