package org.dukcode.ps.codetree.trail05.chapter02.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-count-number-of-points-2/description">LINK</a>
 */
public class ChallengeCountNumberOfPoints2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n; // 2_500
  private static int q; // ~300_000

  private static Set<Point> points;
  private static TreeSet<Integer> xSet;
  private static TreeSet<Integer> ySet;

  private static Map<Integer, Integer> xMapper;
  private static Map<Integer, Integer> yMapper;
  private static Map<Integer, Integer> realXMapper;
  private static Map<Integer, Integer> realYMapper;

  private static int h;
  private static int w;
  private static int[][] pSum;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    q = Integer.parseInt(st.nextToken());

    points = new HashSet<>();
    xSet = new TreeSet<>();
    ySet = new TreeSet<>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      xSet.add(x);
      ySet.add(y);
      points.add(new Point(x, y));
    }

    xMapper = new HashMap<>();
    realXMapper = new HashMap<>();
    int idx = 0;
    for (int x : xSet) {
      xMapper.put(idx, x);
      realXMapper.put(x, idx);
      idx++;
    }

    yMapper = new HashMap<>();
    realYMapper = new HashMap<>();
    idx = 0;
    for (int y : ySet) {
      yMapper.put(idx, y);
      realYMapper.put(y, idx);
      idx++;
    }

    w = xMapper.size();
    h = yMapper.size();
    pSum = new int[w + 1][h + 1];
    for (int y = 1; y <= h; y++) {
      for (int x = 1; x <= w; x++) {
        pSum[y][x] = pSum[y - 1][x] + pSum[y][x - 1] - pSum[y - 1][x - 1]
            + (points.contains(new Point(xMapper.get(x - 1), yMapper.get(y - 1))) ? 1 : 0);
      }
    }

    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      bw.write(String.valueOf(cnt(x1, y1, x2, y2)));
      bw.newLine();
    }

    br.close();
    bw.close();
  }

  private static int cnt(int x1, int y1, int x2, int y2) {
    x1 = xSet.lower(x1) == null ? 0 : (realXMapper.get(xSet.lower(x1)) + 1);
    y1 = ySet.lower(y1) == null ? 0 : (realYMapper.get(ySet.lower(y1)) + 1);
    x2 = xSet.floor(x2) == null ? 0 : (realXMapper.get(xSet.floor(x2)) + 1);
    y2 = ySet.floor(y2) == null ? 0 : (realYMapper.get(ySet.floor(y2)) + 1);

    return pSum[y1][x1] - pSum[y1][x2] - pSum[y2][x1] + pSum[y2][x2];
  }

  private static class Point {

    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
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
