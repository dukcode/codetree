package org.dukcode.ps.codetree.trail05.chapter01.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-frendly-point/description">LINK</a>
 */
public class IntroFrendlyPoint {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static TreeSet<Point> points;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    points = new TreeSet<>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      points.add(new Point(x, y));
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      Point neighbor = points.ceiling(new Point(x, y));

      bw.write(String.valueOf(neighbor == null ? Point.NONE : neighbor));
      bw.newLine();
    }

    br.close();
    bw.close();
  }

  private static class Point implements Comparable<Point> {

    static final Point NONE = new Point(-1, -1);

    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(Point o) {
      if (this.x == o.x) {
        return Integer.compare(this.y, o.y);
      }

      return Integer.compare(this.x, o.x);
    }

    @Override
    public String toString() {
      return x + " " + y;
    }

  }
}
