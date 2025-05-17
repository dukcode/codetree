package org.dukcode.ps.codetree.trail02.chapter04.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-the-day-of-the-day/description">LINK</a>
 */
public class TestTheDayOfTheDay {

  private static final int[] DAYS_OF_MONTH = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
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

    String targetDayOfWeek = br.readLine();
    int idxDayOfWeek = -1;
    for (int i = 0; i < DAYS_OF_WEEK.length; i++) {
      if (DAYS_OF_WEEK[i].equals(targetDayOfWeek)) {
        idxDayOfWeek = i;
        break;
      }
    }

    int totalDays1 = getTotalDays(m1, d1);
    int totalDays2 = getTotalDays(m2, d2);

    int diffDays = totalDays2 - totalDays1;

    int ans = (diffDays / 7) + (diffDays % 7 >= idxDayOfWeek ? 1 : 0);
    if (idxDayOfWeek == 0) {
      ans++;
    }

    bw.write(String.valueOf(ans));
    br.close();
    bw.close();

  }

  private static int getTotalDays(int m, int d) {
    int ret = d;
    for (int i = 1; i < m; i++) {
      ret += DAYS_OF_MONTH[i - 1];
    }

    return ret;
  }
}
