package org.dukcode.ps.codetree.trail02.chapter04.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-time-to-time/description">LINK</a>
 */
public class IntroTimeToTime {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());

    int h1 = Integer.parseInt(st.nextToken());
    int m1 = Integer.parseInt(st.nextToken());
    int h2 = Integer.parseInt(st.nextToken());
    int m2 = Integer.parseInt(st.nextToken());

    bw.write(String.valueOf(elapsedMin(h1, m1, h2, m2)));

    br.close();
    bw.close();

  }

  private static int elapsedMin(int h1, int m1, int h2, int m2) {
    int time1 = h1 * 60 + m1;
    int time2 = h2 * 60 + m2;

    return time2 - time1;
  }
}
