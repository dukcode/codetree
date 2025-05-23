package org.dukcode.ps.codetree.trail02.chapter06.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-a-room-in-a-circle/description">LINK</a>
 */
public class ChallengeARoomInACircle {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    int[] capacities = new int[n];
    for (int i = 0; i < n; i++) {
      capacities[i] = Integer.parseInt(br.readLine());
    }

    int minDist = Integer.MAX_VALUE;
    for (int start = 0; start < n; start++) {

      int dist = 0;
      for (int move = 0; move < n; ++move) {
        int idx = (start + move) % n;
        dist += move * capacities[idx];
      }

      minDist = Math.min(minDist, dist);
    }

    bw.write(String.valueOf(minDist));

    br.close();
    bw.close();

  }
}
