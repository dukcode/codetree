package org.dukcode.ps.codetree.trail02.chapter08.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-hill-cutting/description">LINK</a>
 */
public class ChallengeHillCutting {

  private static final int MIN_DIFF = 17;

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static int n;
  private static int[] heights;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    heights = new int[n];
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      heights[i] = Integer.parseInt(br.readLine());
      min = Math.min(min, heights[i]);
      max = Math.max(max, heights[i]);
    }

    int ans = Integer.MAX_VALUE;
    for (int minHeight = min; minHeight <= max - MIN_DIFF; minHeight++) {
      int maxHeight = minHeight + MIN_DIFF;
      int cost = 0;
      for (int height : heights) {
        if (height < minHeight) {
          cost += (minHeight - height) * (minHeight - height);
        } else if (maxHeight < height) {
          cost += (height - maxHeight) * (height - maxHeight);
        }
      }

      ans = Math.min(ans, cost);
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }
}
