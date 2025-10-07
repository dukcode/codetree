package org.dukcode.ps.codetree.trail05.chapter02.lesson06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-fire-suppression/description">LINK</a>
 */
public class ChallengeFireSuppression {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  private static long[] fires;
  private static TreeSet<Long> firehouses;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    fires = new long[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      fires[i] = Long.parseLong(st.nextToken());
    }

    firehouses = new TreeSet<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      firehouses.add(Long.parseLong(st.nextToken()));
    }

    long ans = 0;
    for (long fire : fires) {
      long higherDist = Long.MAX_VALUE;
      if (firehouses.higher(fire) != null) {
        higherDist = firehouses.higher(fire) - fire;
      }

      long lowerDist = Long.MAX_VALUE;
      if (firehouses.lower(fire) != null) {
        lowerDist = fire - firehouses.lower(fire);
      }

      ans = Math.max(ans, Math.min(higherDist, lowerDist));
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();
  }
}
