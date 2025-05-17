package org.dukcode.ps.codetree.trail02.chapter04.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-guess-day-of-week/description">LINK</a>
 */
public class ChallengeGuessDayOfWeek {

  private static final int[] DAYS_OF_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  private static final String[] DAYS_OF_WEEK = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

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

    int totalDays1 = getTotalDays(m1, d1);
    int totalDays2 = getTotalDays(m2, d2);

    bw.write(calcDaysOfWeek(totalDays1, totalDays2));

    br.close();
    bw.close();

  }

  private static String calcDaysOfWeek(int totalDaysOfMonday, int targetDays) {
    return DAYS_OF_WEEK[((targetDays - totalDaysOfMonday) % 7 + 7) % 7];
  }

  private static int getTotalDays(int m, int d) {
    int ret = d;
    for (int i = 1; i < m; i++) {
      ret += DAYS_OF_MONTH[i - 1];
    }

    return ret;
  }
}
