package org.dukcode.ps.codetree.trail02.chapter07.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-the-tip-of-the-iceberg-2/description">LINK</a>
 */
public class ChallengeTheTipOfTheIceberg2 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static int n;
  private static int[] heights;


  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    heights = new int[n];
    int maxH = Integer.MIN_VALUE;
    int minH = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      heights[i] = Integer.parseInt(br.readLine());
      maxH = Math.max(maxH, heights[i]);
      minH = Math.min(minH, heights[i]);
    }

    int ans = 1;
    for (int h = minH + 1; h < maxH; ++h) {
      ans = Math.max(ans, cnt(h));
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

  private static int cnt(int h) {
    boolean isBeforeWater = true;
    int ret = 0;
    for (int i = 0; i < n; ++i) {
      boolean isNowWater = heights[i] - h <= 0;
      if (isBeforeWater && !isNowWater) {
        ret++;
      }

      isBeforeWater = isNowWater;
    }

    return ret;
  }
}
