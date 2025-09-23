package org.dukcode.ps.codetree.trail05.chapter02.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-the-number-of-points-within-the-range-2/description">LINK</a>
 */
public class ChallengeTheNumberOfPointsWithinTheRange2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int q;
  private static int[] points;
  private static int maxPos;

  private static int[] pSum;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    q = Integer.parseInt(st.nextToken());

    points = new int[n];
    maxPos = -1;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      points[i] = Integer.parseInt(st.nextToken());
      maxPos = Math.max(maxPos, points[i]);
    }

    Arrays.sort(points);

    pSum = new int[maxPos + 1];
    int before = 0;
    int cnt = 0;
    for (int point : points) {
      Arrays.fill(pSum, before, point, cnt);
      cnt++;
      before = point;
    }
    pSum[maxPos] = cnt;

    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      int frIn = Integer.parseInt(st.nextToken());
      int toIn = Integer.parseInt(st.nextToken());

      bw.write(String.valueOf(cnt(frIn, toIn)));
      bw.newLine();
    }

    br.close();
    bw.close();
  }

  private static int cnt(int frIn, int toIn) {
    return (toIn > maxPos ? pSum[maxPos] : pSum[toIn]) - (frIn == 0 ? 0 : pSum[frIn - 1]);
  }
}
