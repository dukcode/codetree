package org.dukcode.ps.codetree.trail02.chapter01.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-with-or-without-2021/description">LINK</a>
 */
public class ChallengeWithOrWithout2021 {

  private static final int[] DAYS_OF_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());

    bw.write(isValid(m, d) ? "Yes" : "No");

    br.close();
    bw.close();

  }

  private static boolean isValid(int m, int d) {
    if (m < 1 || m > 12) {
      return false;
    }

    int lastDay = DAYS_OF_MONTH[m - 1];
    return 1 <= d && d <= lastDay;
  }
}
