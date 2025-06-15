package org.dukcode.ps.codetree.trail02.chapter08.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-balance-on-coordinate-plane-2/description">LINK</a>
 */
public class ChallengeBalanceOnCoordinatePlane2 {

  private static final int X = 0;
  private static final int Y = 1;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[][] points;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    points = new int[n][2];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      points[i][X] = Integer.parseInt(st.nextToken());
      points[i][Y] = Integer.parseInt(st.nextToken());
    }

    int ans = Integer.MAX_VALUE;
    for (int x = 2; x <= 100; x += 2) {
      for (int y = 2; y <= 100; y += 2) {
        ans = Math.min(ans, maxCnt(x, y));
      }
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

  private static int maxCnt(int x, int y) {
    int[] cnt = new int[4];

    for (int[] point : points) {
      if (point[X] < x && point[Y] < y) {
        cnt[0]++;
        continue;
      }

      if (point[X] > x && point[Y] < y) {
        cnt[1]++;
        continue;
      }

      if (point[X] < x && point[Y] > y) {
        cnt[2]++;
        continue;
      }

      cnt[3]++;
    }

    return Arrays.stream(cnt).max().getAsInt();
  }
}
