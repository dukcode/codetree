package org.dukcode.ps.codetree.trail05.chapter05.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-pair-of-points-that-can-be-moved/description">LINK</a>
 */
public class ChallengePairOfPointsThatCanBeMoved {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int p;
  private static int q;

  private static long[][] minDist;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    p = Integer.parseInt(st.nextToken());
    q = Integer.parseInt(st.nextToken());

    minDist = new long[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(minDist[i], Long.MAX_VALUE);
      minDist[i][i] = 0;
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int fr = Integer.parseInt(st.nextToken()) - 1;
      int to = Integer.parseInt(st.nextToken()) - 1;
      long dist = Long.parseLong(st.nextToken());

      minDist[fr][to] = dist;
    }

    for (int mid = 0; mid < n; mid++) {
      for (int fr = 0; fr < n; fr++) {
        for (int to = 0; to < n; to++) {
          if (minDist[fr][mid] == Long.MAX_VALUE || minDist[mid][to] == Long.MAX_VALUE) {
            continue;
          }

          minDist[fr][to] = Math.min(minDist[fr][to], minDist[fr][mid] + minDist[mid][to]);
        }
      }
    }

    int cnt = 0;
    long sumDist = 0L;
    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      int fr = Integer.parseInt(st.nextToken()) - 1;
      int to = Integer.parseInt(st.nextToken()) - 1;

      long dist = Long.MAX_VALUE;
      for (int red = 0; red < p; ++red) {
        if (minDist[fr][red] == Long.MAX_VALUE || minDist[red][to] == Long.MAX_VALUE) {
          continue;
        }

        dist = Math.min(dist, minDist[fr][red] + minDist[red][to]);
      }

      cnt += dist == Long.MAX_VALUE ? 0 : 1;
      sumDist += dist == Long.MAX_VALUE ? 0L : dist;
    }

    bw.write(String.valueOf(cnt));
    bw.newLine();
    bw.write(String.valueOf(sumDist));

    br.close();
    bw.close();
  }
}
