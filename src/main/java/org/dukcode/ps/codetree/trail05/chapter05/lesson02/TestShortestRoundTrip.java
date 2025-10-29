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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-shortest-round-trip/description">LINK</a>
 */
public class TestShortestRoundTrip {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int[][] minDist;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    minDist = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(minDist[i], Integer.MAX_VALUE);
      minDist[i][i] = 0;
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken()) - 1;
      int y = Integer.parseInt(st.nextToken()) - 1;
      int dist = Integer.parseInt(st.nextToken());
      minDist[x][y] = dist;
    }

    for (int mid = 0; mid < n; mid++) {
      for (int fr = 0; fr < n; fr++) {
        for (int to = 0; to < n; to++) {
          if (minDist[fr][mid] == Integer.MAX_VALUE || minDist[mid][to] == Integer.MAX_VALUE) {
            continue;
          }

          minDist[fr][to] = Math.min(minDist[fr][to], minDist[fr][mid] + minDist[mid][to]);
        }
      }
    }

    int ans = Integer.MAX_VALUE;
    for (int a = 0; a < n; a++) {
      for (int b = a + 1; b < n; b++) {
        if (minDist[a][b] == Integer.MAX_VALUE || minDist[b][a] == Integer.MAX_VALUE) {
          continue;
        }

        ans = Math.min(ans, minDist[a][b] + minDist[b][a]);
      }
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();
  }
}
