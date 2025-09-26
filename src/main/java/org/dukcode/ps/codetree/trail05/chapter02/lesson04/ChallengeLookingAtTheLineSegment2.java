package org.dukcode.ps.codetree.trail05.chapter02.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-looking-at-the-line-segment-2/description">LINK</a>
 */
public class ChallengeLookingAtTheLineSegment2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static Point[] points;

  private static TreeMap<Integer, Integer> yToId;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    points = new Point[2 * n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int y = Integer.parseInt(st.nextToken());
      int x1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());

      points[2 * i] = new Point(i, y, x1, true);
      points[2 * i + 1] = new Point(i, y, x2, false);
    }

    Arrays.sort(points, Comparator.comparingInt(p -> p.x));

    yToId = new TreeMap<>();
    Set<Integer> ids = new HashSet<>();
    for (Point point : points) {
      if (point.isStart) {
        yToId.put(point.y, point.id);
      } else {
        yToId.remove(point.y);
      }

      if (!yToId.isEmpty()) {
        ids.add(yToId.firstEntry().getValue());
      }
    }

    bw.write(String.valueOf(ids.size()));

    br.close();
    bw.close();
  }

  private static class Point {

    int id;
    int y;
    int x;
    boolean isStart;

    public Point(int id, int y, int x, boolean isStart) {
      this.id = id;
      this.y = y;
      this.x = x;
      this.isStart = isStart;
    }
  }
}
