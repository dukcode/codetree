package org.dukcode.ps.codetree.trail04.chapter02.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-choose-m-out-of-n-points/description">LINK</a>
 */
public class TestChooseMOutOfNPoints {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static Point[] points;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    points = new Point[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      points[i] = new Point(x, y);
    }

    List<Integer> picked = new ArrayList<>();
    bw.write(String.valueOf(solve(picked, 0)));

    br.close();
    bw.close();

  }

  private static int solve(List<Integer> picked, int maxDist) {
    if (picked.size() == m) {
      return maxDist;
    }

    int ret = Integer.MAX_VALUE;
    int lastIdx = picked.isEmpty() ? -1 : picked.get(picked.size() - 1);
    for (int idx = lastIdx + 1; idx < n; ++idx) {
      int newMaxDist = maxDist;
      for (Integer i : picked) {
        newMaxDist = Math.max(newMaxDist, points[i].dist(points[idx]));
      }

      picked.add(idx);
      ret = Math.min(ret, solve(picked, newMaxDist));
      picked.remove(picked.size() - 1);
    }

    return ret;
  }

  private static class Point {

    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int dist(Point p) {
      return (p.x - this.x) * (p.x - this.x) + (p.y - this.y) * (p.y - this.y);
    }
  }
}
