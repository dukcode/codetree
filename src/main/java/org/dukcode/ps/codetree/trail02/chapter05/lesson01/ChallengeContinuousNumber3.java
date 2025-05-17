package org.dukcode.ps.codetree.trail02.chapter05.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-continuous-number3/description">LINK</a>
 */
public class ChallengeContinuousNumber3 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    int sign = 0;
    int cnt = 0;
    int maxCnt = 0;
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(br.readLine());
      int curSign = num < 0 ? -1 : 1;

      if (sign != curSign) {
        maxCnt = Math.max(maxCnt, cnt);
        sign = curSign;
        cnt = 1;
        continue;
      }

      cnt++;
    }

    maxCnt = Math.max(maxCnt, cnt);

    bw.write(String.valueOf(maxCnt));

    br.close();
    bw.close();

  }
}
