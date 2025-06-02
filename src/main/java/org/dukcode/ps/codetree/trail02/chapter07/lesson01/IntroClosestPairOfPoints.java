package org.dukcode.ps.codetree.trail02.chapter07.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-closest-pair-of-points/description">LINK</a>
 */
public class IntroClosestPairOfPoints {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] x;
  private static int[] y;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    x = new int[n];
    y = new int[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      x[i] = Integer.parseInt(st.nextToken());
      y[i] = Integer.parseInt(st.nextToken());
    }

    int ans = minDist();

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

  private static int minDist() {
    int ret = Integer.MAX_VALUE;
    for (int first = 0; first < n; first++) {
      for (int second = first + 1; second < n; second++) {
        ret = Math.min(ret, dist(first, second));
      }
    }
    return ret;
  }

  private static int dist(int first, int second) {
    int dx = x[first] - x[second];
    int dy = y[first] - y[second];

    return dx * dx + dy * dy;
  }
}
