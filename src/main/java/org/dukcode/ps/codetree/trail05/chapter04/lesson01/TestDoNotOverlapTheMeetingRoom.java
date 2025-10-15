package org.dukcode.ps.codetree.trail05.chapter04.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-do-not-overlap-the-meeting-room/description">LINK</a>
 */
public class TestDoNotOverlapTheMeetingRoom {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    Meeting[] meetings = new Meeting[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      meetings[i] = new Meeting(s, e);
    }

    Arrays.sort(meetings, Comparator.comparingInt(m -> m.e));

    int skip = 0;
    int lastEnd = 0;
    for (int i = 0; i < n; ++i) {
      if (lastEnd <= meetings[i].s) {
        lastEnd = meetings[i].e;
      } else {
        skip++;
      }
    }

    bw.write(String.valueOf(skip));

    br.close();
    bw.close();
  }

  private static class Meeting {

    int s;
    int e;

    public Meeting(int s, int e) {
      this.s = s;
      this.e = e;
    }
  }
}
