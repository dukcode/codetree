package org.dukcode.ps.codetree.trail05.chapter03.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-point-on-the-line-segment/description">LINK</a>
 */
public class ChallengePointOnTheLineSegment {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int[] points;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    points = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      points[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(points);

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());

      bw.write(String.valueOf(solve(x1, x2)));
      bw.newLine();
    }

    br.close();
    bw.close();
  }

  private static int solve(int x1, int x2) {
    return upperBound(x2) - lowerBound(x1);
  }

  private static int upperBound(int target) {
    int frIn = 0;
    int toEx = n;
    while (frIn < toEx) {
      int mid = (frIn + toEx) / 2;

      if (points[mid] <= target) {
        frIn = mid + 1;
      } else {
        toEx = mid;
      }
    }
    return frIn;
  }

  private static int lowerBound(int target) {
    int frIn = 0;
    int toEx = n;
    while (frIn < toEx) {
      int mid = (frIn + toEx) / 2;

      if (points[mid] < target) {
        frIn = mid + 1;
      } else {
        toEx = mid;
      }
    }
    return frIn;
  }
}
