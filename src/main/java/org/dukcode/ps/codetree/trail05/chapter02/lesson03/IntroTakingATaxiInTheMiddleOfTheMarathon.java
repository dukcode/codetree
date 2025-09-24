package org.dukcode.ps.codetree.trail05.chapter02.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-taking-a-taxi-in-the-middle-of-the-marathon/description">LINK</a>
 */
public class IntroTakingATaxiInTheMiddleOfTheMarathon {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static Point[] points;

  /*
  범위
  - n : 3 ~ 100_000
  - x, y : -1_000 ~ 1_000

  시간복잡도
  - brute force : O(N^2) -> O(1_000_000_000_000) -> 불가능

  - prefixSum : O(N)
   */

  private static int[] pSumLeft; // dist(idx - 1, idx)
  private static int[] pSumRight; // dist(idx, idx + 1)

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    points = new Point[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      points[i] = new Point(x, y);
    }

    pSumLeft = new int[n];
    for (int i = 1; i < n; i++) {
      pSumLeft[i] = pSumLeft[i - 1] + dist(points[i - 1], points[i]);
    }

    pSumRight = new int[n];
    for (int i = n - 2; i >= 0; i--) {
      pSumRight[i] = pSumRight[i + 1] + dist(points[i], points[i + 1]);
    }

    int ans = Integer.MAX_VALUE;
    for (int i = 1; i < n - 1; i++) {
      int dist = pSumLeft[i - 1] + dist(points[i - 1], points[i + 1]) + pSumRight[i + 1];
      ans = Math.min(ans, dist);
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();
  }

  private static int dist(Point p1, Point p2) {
    return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
  }

  private static class Point {

    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
