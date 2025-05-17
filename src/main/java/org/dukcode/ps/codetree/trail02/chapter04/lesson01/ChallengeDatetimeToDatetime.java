package org.dukcode.ps.codetree.trail02.chapter04.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-datetime-to-datetime/description">LINK</a>
 */
public class ChallengeDatetimeToDatetime {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    int dayOfMonth = Integer.parseInt(st.nextToken());
    int hour = Integer.parseInt(st.nextToken());
    int minute = Integer.parseInt(st.nextToken());

    int fromTotalMin = 11 * 60 + 11;
    int toTotalMin = (dayOfMonth - 11) * 24 * 60 + hour * 60 + minute;

    int diffMin = toTotalMin - fromTotalMin;
    bw.write(String.valueOf(diffMin < 0 ? -1 : diffMin));

    br.close();
    bw.close();

  }
}
