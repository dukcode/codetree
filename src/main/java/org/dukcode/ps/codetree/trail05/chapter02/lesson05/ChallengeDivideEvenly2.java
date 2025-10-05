package org.dukcode.ps.codetree.trail05.chapter02.lesson05;

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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-divide-evenly-2/description">LINK</a>
 */
public class ChallengeDivideEvenly2 {

  private static final int RANGE = 1_000;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static Point[] points;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    points = new Point[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      points[i] = new Point(x, y);
    }

    Arrays.sort(points, Comparator.comparingInt(p -> p.x));

    int ans = Integer.MAX_VALUE;
    for (int y = 0; y <= RANGE; y += 2) {
      int[] cnt = new int[4];

      for (int idx = 0; idx < n; idx++) {
        if (points[idx].y > y) {
          cnt[0]++;
        } else {
          cnt[3]++;
        }
      }

      for (int idx = 0; idx < n; idx++) {

        if (idx == 0 || points[idx - 1].x != points[idx].x) {
          ans = Math.min(ans, getMax(cnt));
        }

        if (points[idx].y > y) {
          cnt[0]--;
          cnt[1]++;
        } else {
          cnt[3]--;
          cnt[2]++;
        }

      }

      ans = Math.min(ans, getMax(cnt));

    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();
  }

  private static int getMax(int[] arr) {
    int ret = -1;
    for (int i : arr) {
      ret = Math.max(ret, i);
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
  }
}
