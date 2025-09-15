package org.dukcode.ps.codetree.trail05.chapter01.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-remove-point/description">LINK</a>
 */
public class ChallengeRemovePoint {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    TreeSet<Point> points = new TreeSet<>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      points.add(new Point(x, y));
    }

    for (int i = 0; i < m; i++) {
      int k = Integer.parseInt(br.readLine());
      Point ceilingPoint = points.ceiling(new Point(k, 0));
      if (ceilingPoint == null) {
        bw.write("-1 -1");
      } else {
        points.remove(ceilingPoint);
        bw.write(ceilingPoint.x + " " + ceilingPoint.y);
      }
      bw.newLine();
    }

    br.close();
    bw.close();
  }

  private static class Point implements Comparable<Point> {

    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(Point o) {
      return x == o.x ? Integer.compare(y, o.y) : Integer.compare(x, o.x);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Point point = (Point) o;
      return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }
}
