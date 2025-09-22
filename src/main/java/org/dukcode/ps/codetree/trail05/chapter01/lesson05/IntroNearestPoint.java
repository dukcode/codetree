package org.dukcode.ps.codetree.trail05.chapter01.lesson05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-nearest-point/description">LINK</a>
 */
public class IntroNearestPoint {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static PriorityQueue<Point> pq;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    pq = new PriorityQueue<>(n);
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      pq.offer(new Point(x, y));
    }

    for (int i = 0; i < m; ++i) {
      Point nearest = pq.poll();
      pq.offer(new Point(nearest.x + 2, nearest.y + 2));
    }

    Point ans = pq.poll();
    bw.write(String.valueOf(ans.x));
    bw.write(' ');
    bw.write(String.valueOf(ans.y));

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
      if (dist() == o.dist() && this.x == o.x) {
        return Integer.compare(this.y, o.y);
      }

      if (dist() == o.dist()) {
        return Integer.compare(this.x, o.x);
      }

      return Integer.compare(dist(), o.dist());
    }

    private int dist() {
      return Math.abs(x) + Math.abs(y);
    }
  }
}
