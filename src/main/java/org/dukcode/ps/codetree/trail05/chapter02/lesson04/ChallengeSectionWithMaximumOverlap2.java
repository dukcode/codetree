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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-section-with-maximum-overlap-2/description">LINK</a>
 */
public class ChallengeSectionWithMaximumOverlap2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    Point[] points = new Point[n * 2];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());

      points[i * 2] = new Point(x1, 1);
      points[i * 2 + 1] = new Point(x2, -1);
    }

    Arrays.sort(points, Comparator.comparingInt(p -> p.x));

    int ans = 0;
    int overlapped = 0;
    for (Point point : points) {
      overlapped += point.v;
      ans = Math.max(ans, overlapped);
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
