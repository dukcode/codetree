package org.dukcode.ps.codetree.trail04.chapter02.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-traveling-salesman-problem/description">LINK</a>
 */
public class ChallengeTravelingSalesmanProblem {

  private static final int MX = 987_654_321;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[][] dist;

  private static boolean[] taken;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    dist = new int[n][n];
    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < n; x++) {
        dist[y][x] = Integer.parseInt(st.nextToken());
      }
    }
    taken = new boolean[n];
    taken[0] = true;
    bw.write(String.valueOf(solve(0, 0, 1)));

    br.close();
    bw.close();

  }

  private static int solve(int lastIdx, int sumDist, int cnt) {
    if (cnt == n) {
      return sumDist + (dist[lastIdx][0] == 0 ? MX : dist[lastIdx][0]);
    }

    int ret = MX;
    for (int idx = 0; idx < n; idx++) {
      if (taken[idx]) {
        continue;
      }

      if (dist[lastIdx][idx] == 0) {
        continue;
      }

      taken[idx] = true;
      ret = Math.min(ret, solve(idx, sumDist + dist[lastIdx][idx], cnt + 1));
      taken[idx] = false;
    }

    return ret;
  }
}
