package org.dukcode.ps.codetree.trail05.chapter02.lesson06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-the-minimum-difference-in-coordinate-range/description">LINK</a>
 */
public class ChallengeTheMinimumDifferenceInCoordinateRange {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int d; // 높이가 d 이상인 직사각형 중 너비가 가장 작은 사각형의 너비를 출력

  private static Point[] points;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());

    points = new Point[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      points[i] = new Point(x, y);
    }

    Arrays.sort(points, Comparator.comparingInt(p -> p.x));

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    TreeSet<Point> between = new TreeSet<>((a, b) -> a.y == b.y ? a.x - b.x : a.y - b.y);
    int ans = Integer.MAX_VALUE;
    int toIn = -1;
    for (int frIn = 0; frIn < n - 1; frIn++) {
      while (toIn < n - 1 && getMaxHeight(between) < d) {
        toIn++;
        between.add(points[toIn]);
      }

      if (getMaxHeight(between) < d) {
        break;
      }

      ans = Math.min(ans, points[toIn].x - points[frIn].x);

      between.remove(points[frIn]);
    }
    return ans == Integer.MAX_VALUE ? -1 : ans;
  }

  private static int getMaxHeight(TreeSet<Point> between) {
    return getMax(between) - getMin(between);
  }

  private static int getMin(TreeSet<Point> between) {
    if (between.isEmpty()) {
      return 0;
    }

    return between.first().y;
  }

  private static int getMax(TreeSet<Point> between) {
    if (between.isEmpty()) {
      return 0;
    }

    return between.last().y;
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
