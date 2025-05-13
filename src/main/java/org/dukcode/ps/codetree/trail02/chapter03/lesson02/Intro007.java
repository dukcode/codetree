package org.dukcode.ps.codetree.trail02.chapter03.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-007/description">LINK</a>
 */
public class Intro007 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    Meeting meeting = new Meeting(
        st.nextToken(),
        st.nextToken(),
        Integer.parseInt(st.nextToken())
    );

    bw.write(meeting.toString());

    br.close();
    bw.close();

  }

  private static class Meeting {

    private String code;
    private String spot;
    private int time;

    public Meeting(String code, String spot, int time) {
      this.code = code;
      this.spot = spot;
      this.time = time;
    }

    @Override
    public String toString() {
      return "secret code : " + code + "\n"
          + "meeting point : " + spot + "\n"
          + "time : " + time + "\n";
    }
  }
}
