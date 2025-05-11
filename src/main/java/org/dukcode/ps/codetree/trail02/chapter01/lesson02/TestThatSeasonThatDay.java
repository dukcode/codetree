package org.dukcode.ps.codetree.trail02.chapter01.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-that-season-that-day/description">LINK</a>
 */
public class TestThatSeasonThatDay {

  private static final int[] DAYS_OF_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    int year = Integer.parseInt(st.nextToken());
    int month = Integer.parseInt(st.nextToken());
    int day = Integer.parseInt(st.nextToken());

    bw.write(calcSeason(year, month, day));

    br.close();
    bw.close();

  }

  private static String calcSeason(int year, int month, int day) {
    int lastDay = calcLastDay(year, month);

    if (day > lastDay) {
      return "-1";
    }

    if (3 <= month && month <= 5) {
      return "Spring";
    }

    if (6 <= month && month <= 8) {
      return "Summer";
    }

    if (9 <= month && month <= 11) {
      return "Fall";
    }

    return "Winter";
  }

  private static int calcLastDay(int year, int month) {
    if (isLeapYear(year) && month == 2) {
      return 29;
    }

    return DAYS_OF_MONTH[month - 1];
  }

  private static boolean isLeapYear(int year) {
    return (year % 4 == 0) && !(year % 100 == 0 && year % 400 != 0);
  }
}
