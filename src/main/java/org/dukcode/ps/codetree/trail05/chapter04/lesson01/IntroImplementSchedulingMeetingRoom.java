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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-implement-scheduling-meeting-room/description">LINK</a>
 */
public class IntroImplementSchedulingMeetingRoom {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static Meeting[] meetings;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    meetings = new Meeting[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      meetings[i] = new Meeting(s, e);
    }

    Arrays.sort(meetings, Comparator.comparingInt(m -> m.e));

    int cnt = 0;
    int end = 0;
    for (Meeting meeting : meetings) {
      if (end <= meeting.s) {
        end = meeting.e;
        cnt++;
      }
    }

    bw.write(String.valueOf(cnt));

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
