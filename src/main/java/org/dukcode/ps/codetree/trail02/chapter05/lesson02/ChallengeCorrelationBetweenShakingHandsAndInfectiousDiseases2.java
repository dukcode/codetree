package org.dukcode.ps.codetree.trail02.chapter05.lesson02;

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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-correlation-between-shaking-hands-and-infectious-diseases2/description">LINK</a>
 */
public class ChallengeCorrelationBetweenShakingHandsAndInfectiousDiseases2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int k;
  private static int p;
  private static int m;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    p = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    Handshake[] handshakes = new Handshake[m];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int t = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken()) - 1;
      int y = Integer.parseInt(st.nextToken()) - 1;

      handshakes[i] = new Handshake(t, x, y);
    }

    Arrays.sort(handshakes, Comparator.comparingInt(h -> h.t));

    boolean[] infected = new boolean[n];
    int[] remainInfectCnt = new int[n];

    infected[p - 1] = true;
    remainInfectCnt[p - 1] = k;
    for (Handshake handshake : handshakes) {
      int x = handshake.x;
      int y = handshake.y;

      if (!infected[x] && !infected[y]) {
        continue;
      }

      if (infected[x] && infected[y]) {
        remainInfectCnt[x]--;
        remainInfectCnt[y]--;
        continue;
      }

      if (infected[y] && remainInfectCnt[y] > 0) {
        remainInfectCnt[y]--;
        infected[x] = true;
        remainInfectCnt[x] = k;
        continue;
      }

      if (infected[x] && remainInfectCnt[x] > 0) {
        remainInfectCnt[x]--;
        infected[y] = true;
        remainInfectCnt[y] = k;
      }
    }

    for (boolean i : infected) {
      bw.write(String.valueOf(i ? 1 : 0));
    }

    br.close();
    bw.close();

  }

  private static class Handshake {

    int t;
    int x;
    int y;

    public Handshake(int t, int x, int y) {
      this.t = t;
      this.x = x;
      this.y = y;
    }
  }
}
