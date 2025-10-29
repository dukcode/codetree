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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-cheapest-meeting/description">LINK</a>
 */
public class ChallengeCheapestMeeting {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  private static int v1;
  private static int v2;
  private static int e;

  private static int[][] minCost;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    v1 = Integer.parseInt(st.nextToken()) - 1;
    v2 = Integer.parseInt(st.nextToken()) - 1;
    e = Integer.parseInt(st.nextToken()) - 1;

    minCost = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(minCost[i], Integer.MAX_VALUE);
      minCost[i][i] = 0;
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int fr = Integer.parseInt(st.nextToken()) - 1;
      int to = Integer.parseInt(st.nextToken()) - 1;
      int cost = Integer.parseInt(st.nextToken());

      minCost[fr][to] = Math.min(minCost[fr][to], cost);
      minCost[to][fr] = Math.min(minCost[to][fr], cost);
    }

    for (int mid = 0; mid < n; mid++) {
      for (int fr = 0; fr < n; fr++) {
        for (int to = 0; to < n; to++) {
          if (minCost[fr][mid] == Integer.MAX_VALUE || minCost[mid][to] == Integer.MAX_VALUE) {
            continue;
          }

          minCost[fr][to] = Math.min(minCost[fr][to], minCost[fr][mid] + minCost[mid][to]);
        }
      }
    }

    int ans = Integer.MAX_VALUE;
    for (int joinIdx = 0; joinIdx < n; joinIdx++) {
      if (minCost[v1][joinIdx] == Integer.MAX_VALUE ||
          minCost[v2][joinIdx] == Integer.MAX_VALUE ||
          minCost[joinIdx][e] == Integer.MAX_VALUE) {
        continue;
      }

      ans = Math.min(ans, minCost[v1][joinIdx] + minCost[v2][joinIdx] + minCost[joinIdx][e]);
    }

    bw.write(String.valueOf(ans == Integer.MAX_VALUE ? -1 : ans));

    br.close();
    bw.close();
  }
}
