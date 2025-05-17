package org.dukcode.ps.codetree.trail02.chapter05.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-keep-the-lead/description">LINK</a>
 */
public class ChallengeKeepTheLead {

  private static final int NONE = 0;
  private static final int A = 1;
  private static final int B = -1;

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
    int[] posB = new int[MX_T + 1];
    int time = Math.min(recordPos(n, posA), recordPos(m, posB));

    int cnt = 0;
    int leader = NONE; // A = 1 B = -1
    for (int t = 1; t < time; ++t) {
      if (posA[t] < posB[t]) {
        if (leader == A) {
          cnt++;
        }
        leader = B;
      } else if (posA[t] > posB[t]) {
        if (leader == B) {
          cnt++;
        }
        leader = A;
      }

    }

    bw.write(String.valueOf(cnt));

    br.close();
    bw.close();

  }

  private static int recordPos(int n, int[] pos) throws IOException {
    int time = 1;
    int p = 0;
    for (int i = 0; i < n; ++i) {
      st = new StringTokenizer(br.readLine());
      int v = Integer.parseInt(st.nextToken());
      int dt = Integer.parseInt(st.nextToken());

      for (int t = time; t < time + dt; ++t) {
        pos[t] = p + v;
        p += v;
      }

      time += dt;
    }

    return time;
  }
}
