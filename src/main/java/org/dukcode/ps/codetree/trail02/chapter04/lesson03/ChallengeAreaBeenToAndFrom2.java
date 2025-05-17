package org.dukcode.ps.codetree.trail02.chapter04.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-area-been-to-and-from2/description">LINK</a>
 */
public class ChallengeAreaBeenToAndFrom2 {

  private static final int[] DIR = {-1, 1};
  private static final int RANGE = 1000;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] trace = new int[RANGE * 2 + 1];
    int n = Integer.parseInt(br.readLine());

    int cur = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int dist = Integer.parseInt(st.nextToken());
      int dir = st.nextToken().equals("L") ? DIR[0] : DIR[1];

      int dest = cur + dist * dir;

      int frIn = Math.min(cur, dest);
      int toEx = Math.max(cur, dest);

      for (int idx = frIn; idx < toEx; idx++) {
        trace[idx + RANGE]++;
      }

      cur = dest;
    }

    int ans = 0;
    for (int i = 0; i <= 2 * RANGE; i++) {
      if (trace[i] > 1) {
        ans++;
      }
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }
}
