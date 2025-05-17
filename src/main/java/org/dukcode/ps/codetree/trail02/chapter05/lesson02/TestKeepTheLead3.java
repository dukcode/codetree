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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-keep-the-lead-3/description">LINK</a>
 */
public class TestKeepTheLead3 {

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

    int[] posA = new int[MX_T];
    Arrays.fill(posA, -1);
    posA[0] = 0;
    int[] posB = new int[MX_T];
    Arrays.fill(posB, -1);
    posB[0] = 0;

    int time = Math.min(recordPos(posA, n), recordPos(posB, m));

    int headBefore = 0;
    int cnt = 0;
    for (int i = 1; i < time; i++) {
      int headNow = Integer.compare(posA[i], posB[i]);
      if (headBefore != headNow) {
        cnt++;
      }
      headBefore = headNow;
    }

    bw.write(String.valueOf(cnt));

    br.close();
    bw.close();
  }


  private static int recordPos(int[] pos, int n) throws IOException {
    int p = 0;
    int curTime = 1;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int v = Integer.parseInt(st.nextToken());
      int t = Integer.parseInt(st.nextToken());

      for (int time = curTime; time < curTime + t; time++) {
        p += v;
        pos[time] = p;
      }

      curTime += t;
    }

    return curTime;
  }
}
