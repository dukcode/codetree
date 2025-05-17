package org.dukcode.ps.codetree.trail02.chapter05.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-robot-moving-from-side-to-side/description">LINK</a>
 */
public class ChallengeRobotMovingFromSideToSide {

  private static final int MX_T = 1_000_000;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] posA = new int[MX_T + 1];
    Arrays.fill(posA, Integer.MAX_VALUE);
    posA[0] = 0;
    int[] posB = new int[MX_T + 1];
    Arrays.fill(posB, Integer.MAX_VALUE);
    posB[0] = 0;

    int time = Math.max(recordPos(posA, n), recordPos(posB, m));

    int cnt = 0;
    for (int t = 1; t < time; ++t) {
      posA[t] = posA[t] == Integer.MAX_VALUE ? posA[t - 1] : posA[t];
      posB[t] = posB[t] == Integer.MAX_VALUE ? posB[t - 1] : posB[t];
      if (posA[t - 1] != posB[t - 1] && posA[t] == posB[t]) {
        cnt++;
      }

    }

    bw.write(String.valueOf(cnt));

    br.close();
    bw.close();

  }

  private static int recordPos(int[] pos, int n) throws IOException {
    int time = 1;
    int cur = 0;
    for (int i = 0; i < n; ++i) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int dir = st.nextToken().equals("R") ? 1 : -1;

      for (int t = time; t < time + x; ++t) {
        cur += dir;
        pos[t] = cur;
      }

      time += x;
    }

    return time;
  }
}
