package org.dukcode.ps.codetree.trail05.chapter03.lesson02;

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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-two-points-of-the-line-that-dont-overlap/description">LINK</a>
 */
public class ChallengeTwoPointsOfTheLineThatDontOverlap {

  private static final long MX_DIST = 1_000_000_000_000_000_000L;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static long n;
  private static int m;
  private static Line[] lines;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Long.parseLong(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    lines = new Line[m];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      long x1 = Long.parseLong(st.nextToken());
      long x2 = Long.parseLong(st.nextToken());
      lines[i] = new Line(x1, x2);
    }

    Arrays.sort(lines, Comparator.comparingLong(l -> l.x1));

    bw.write(String.valueOf(cntToMinimaxDist(n)));

    br.close();
    bw.close();
  }

  private static long cntToMinimaxDist(long cnt) {
    long frIn = 1L;
    long toEx = MX_DIST + 1L;

    while (frIn < toEx) {
      long mid = (frIn + toEx) / 2;

      if (minDistToCnt(mid) >= cnt) {
        frIn = mid + 1;
      } else {
        toEx = mid;
      }
    }

    return frIn - 1;
  }

  private static long minDistToCnt(long minDist) {
    long ret = 0L;
    long lastPos = -minDist;
    for (Line line : lines) {
      long start = Math.max(lastPos + minDist, line.x1);
      long end = line.x2;

      if (start > end) {
        continue;
      }

      long mod = (end - start) / minDist;
      ret += 1 + mod;
      lastPos = start + minDist * mod;
    }

    return ret;
  }


  private static class Line {

    long x1;
    long x2;

    public Line(long x1, long x2) {
      this.x1 = x1;
      this.x2 = x2;
    }
  }
}
