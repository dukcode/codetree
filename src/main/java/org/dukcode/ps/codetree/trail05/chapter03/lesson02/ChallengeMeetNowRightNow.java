package org.dukcode.ps.codetree.trail05.chapter03.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-meet-now-right-now/description">LINK</a>
 */
public class ChallengeMeetNowRightNow {

  private static final int RANGE = 1_000_000_000;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static long[] x;
  private static long[] v;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    x = new long[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      x[i] = Long.parseLong(st.nextToken());
    }

    v = new long[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      v[i] = Long.parseLong(st.nextToken());
    }

    bw.write(String.format("%.4f", solve()));

    br.close();
    bw.close();
  }

  private static double solve() {
    double frIn = 0.0;
    double toEx = 1.0 + (RANGE - 1.0) / 2.0;

    while (frIn + 0.00001 < toEx) {
      double mid = (frIn + toEx) / 2.0;

      if (isPossible(mid)) {
        toEx = mid;
      } else {
        frIn = mid + 0.00001;
      }
    }

    return frIn;
  }

  private static boolean isPossible(double time) {
    double fr = -1;
    double to = RANGE + 1;
    for (int i = 0; i < n; i++) {
      double x1 = x[i] - v[i] * time;
      double x2 = x[i] + v[i] * time;

      fr = Math.max(fr, x1);
      to = Math.min(to, x2);

      if (fr > to) {
        return false;
      }
    }

    return true;
  }
}
