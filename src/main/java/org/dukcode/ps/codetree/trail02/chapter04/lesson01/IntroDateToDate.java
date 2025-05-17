package org.dukcode.ps.codetree.trail02.chapter04.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-date-to-date/description">LINK</a>
 */
public class IntroDateToDate {

  private static final int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    int m1 = Integer.parseInt(st.nextToken());
    int d1 = Integer.parseInt(st.nextToken());
    int m2 = Integer.parseInt(st.nextToken());
    int d2 = Integer.parseInt(st.nextToken());

    bw.write(String.valueOf(totalDays(m1, d1, m2, d2)));

    br.close();
    bw.close();
  }

  private static int totalDays(int m1, int d1, int m2, int d2) {
    int totalDays1 = d1;
    for (int i = 1; i < m1; ++i) {
      totalDays1 += DAYS_IN_MONTH[i - 1];
    }

    int totalDays2 = d2;
    for (int i = 1; i < m2; ++i) {
      totalDays2 += DAYS_IN_MONTH[i - 1];
    }

    return totalDays2 - totalDays1 + 1;
  }
}
