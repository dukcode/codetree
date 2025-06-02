package org.dukcode.ps.codetree.trail02.chapter07.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-hours-in-service/description">LINK</a>
 */
public class ChallengeHoursInService {

  private static final int MX_TIME = 1000;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] frIn;
  private static int[] toEx;
  private static int[] time;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    frIn = new int[n];
    toEx = new int[n];
    time = new int[MX_TIME + 1];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      frIn[i] = Integer.parseInt(st.nextToken());
      toEx[i] = Integer.parseInt(st.nextToken());

      for (int t = frIn[i]; t < toEx[i]; t++) {
        time[t]++;
      }
    }

    int totalTime = 0;
    for (int t : time) {
      if (t != 0) {
        totalTime++;
      }
    }

    int ans = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      int subTime = totalTime;
      for (int t = frIn[i]; t < toEx[i]; t++) {
        if (time[t] - 1 == 0) {
          subTime--;
        }
      }

      ans = Math.max(ans, subTime);
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }
}
