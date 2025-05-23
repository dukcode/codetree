package org.dukcode.ps.codetree.trail02.chapter06.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-taking-a-taxi-in-the-middle-of-the-marathon-2/description">LINK</a>
 */
public class ChallengeTakingATaxiInTheMiddleOfTheMarathon2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int[][] checkpoints;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    checkpoints = new int[n][];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      checkpoints[i] = new int[]{x, y};
    }

    int minDist = Integer.MAX_VALUE;
    for (int pass = 1; pass < n - 1; ++pass) {
      int dist = 0;
      int[] posBefore = checkpoints[0];
      for (int idx = 1; idx < n; ++idx) {
        if (idx == pass) {
          continue;
        }

        dist += Math.abs(checkpoints[idx][0] - posBefore[0]) +
            Math.abs(checkpoints[idx][1] - posBefore[1]);

        posBefore = checkpoints[idx];
      }

      minDist = Math.min(minDist, dist);
    }

    bw.write(String.valueOf(minDist));

    br.close();
    bw.close();

  }
}
