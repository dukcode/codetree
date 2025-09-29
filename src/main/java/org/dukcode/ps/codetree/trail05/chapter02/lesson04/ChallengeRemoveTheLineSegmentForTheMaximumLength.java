package org.dukcode.ps.codetree.trail05.chapter02.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-remove-the-line-segment-for-the-maximum-length/description">LINK</a>
 */
public class ChallengeRemoveTheLineSegmentForTheMaximumLength {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static Point[] points;
  private static int[] weights;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    points = new Point[2 * n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      points[2 * i] = new Point(i, x1, +1);
      points[2 * i + 1] = new Point(i, x2, -1);
    }

    Arrays.sort(points);

    weights = new int[n];
    int totalLength = 0;
    HashSet<Integer> segments = new HashSet<>();
    int prevX = points[0].x;
    for (int i = 0; i < 2 * n; i++) {
      int id = points[i].id;
      int x = points[i].x;
      int diff = points[i].diff;

      int segCnt = segments.size();

      totalLength += segCnt > 0 ? x - prevX : 0;

      if (segCnt == 1) {
        int targetId = segments.iterator().next();
        weights[targetId] += x - prevX;
      }

      if (diff == 1) {
        segments.add(id);
      } else {
        segments.remove(id);
      }

      prevX = x;
    }

    int minLength = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      minLength = Math.min(minLength, weights[i]);
    }

    int ans = totalLength - minLength;

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();
  }

  private static class Point implements Comparable<Point> {

    int id;
    int x;
    int diff;

    public Point(int id, int x, int diff) {
      this.id = id;
      this.x = x;
      this.diff = diff;
    }

    @Override
    public int compareTo(Point p) {
      return this.x - p.x;
    }
  }

}