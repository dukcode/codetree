package org.dukcode.ps.codetree.trail05.chapter02.lesson04;

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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-size-of-largest-interval/description">LINK</a>
 */
public class ChallengeSizeOfLargestInterval {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static Point[] points;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    points = new Point[2 * n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());

      points[2 * i] = new Point(x1, 1);
      points[2 * i + 1] = new Point(x2, -1);
    }

    Arrays.sort(points, Comparator.comparingInt(p -> p.x));

    int ans = 0;
    int overlapped = 0;
    int before = points[0].x;
    for (Point p : points) {
      if (overlapped == 0) {
        before = p.x;
      }

      overlapped += p.v;

      if (overlapped == 0) {
        ans = Math.max(ans, p.x - before);
      }
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();
  }

  private static class Point {

    int x;
    int v;

    public Point(int x, int v) {
      this.x = x;
      this.v = v;
    }
  }
}
