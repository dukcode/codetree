package org.dukcode.ps.codetree.trail02.chapter05.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-the-moment-we-meet/description">LINK</a>
 */
public class IntroTheMomentWeMeet {

  private static final int RANGE = 1_000_000;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] posA = new int[2 * RANGE + 1];
    int[] posB = new int[2 * RANGE + 1];

    int time = Math.min(recordPos(posA, n), recordPos(posB, m));

    int meetTime = -1;
    for (int i = 1; i < time; i++) {
      if (posA[i + RANGE] == posB[i + RANGE]) {
        meetTime = i;
        break;
      }
    }

    bw.write(String.valueOf(meetTime));

    br.close();
    bw.close();

  }

  private static int recordPos(int[] pos, int n) throws IOException {
    int p = 0;
    int time = 1;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int dir = st.nextToken().equals("L") ? -1 : 1;
      int t = Integer.parseInt(st.nextToken());

      for (int now = time; now < time + t; ++now) {
        p += dir;
        pos[now + RANGE] = p;
      }

      time += t;
    }

    return time;
  }

}
