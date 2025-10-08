package org.dukcode.ps.codetree.trail05.chapter03.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-minimum-transit-time/description">LINK</a>
 */
public class ChallengeMinimumTransitTime {

  private static final long MX_TIME = 1_000_000_000L * 100_000L;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static long n;
  private static int m;
  private static long[] times;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Long.parseLong(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    times = new long[m];
    for (int i = 0; i < m; i++) {
      times[i] = Long.parseLong(br.readLine());
    }

    bw.write(String.valueOf(cntToMinTime(n)));

    br.close();
    bw.close();
  }

  private static long cntToMinTime(long targetCnt) {
    long frIn = 0;
    long toEx = MX_TIME + 1;

    while (frIn < toEx) {
      long mid = (frIn + toEx) / 2;

      if (timeToMaxCnt(mid) < targetCnt) {
        frIn = mid + 1;
      } else {
        toEx = mid;
      }
    }

    return frIn;
  }

  private static long timeToMaxCnt(long time) {
    long ret = 0;

    for (long t : times) {
      ret += time / t;
    }

    return ret;
  }
}
