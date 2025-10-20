package org.dukcode.ps.codetree.trail05.chapter05.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-shortest-path-to-each-vertex-3/description">LINK</a>
 */
public class IntroShortestPathToEachVertex3 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int[][] graph;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    graph = new int[n][n];
    for (int y = 0; y < n; y++) {
      Arrays.fill(graph[y], -1);
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken()) - 1;
      int to = Integer.parseInt(st.nextToken()) - 1;
      int dist = Integer.parseInt(st.nextToken());

      graph[from][to] = dist;
    }

    int[] ans = dijkstra(0);

    for (int i = 1; i < n; ++i) {
      bw.write(String.valueOf(ans[i] == Integer.MAX_VALUE ? -1 : ans[i]));
      bw.newLine();
    }

    br.close();
    bw.close();
  }

  private static int[] dijkstra(int start) {
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);

    boolean[] visited = new boolean[n];

    dist[start] = 0;

    for (int i = 0; i < n; i++) { // n 번 반복

      // 후보들 중 하나 선택 -> 후보들 중 최단거리인 놈이 확정
      int minIdx = -1;
      int minDist = Integer.MAX_VALUE;
      for (int idx = 0; idx < n; idx++) {
        if (!visited[idx] && dist[idx] < minDist) {
          minIdx = idx;
          minDist = dist[idx];
        }
      }

      if (minIdx == -1) {
        return dist;
      }

      visited[minIdx] = true;

      // 방문된 곳으로 부터 뻗어나가서 후보들 갱신
      for (int idx = 0; idx < n; ++idx) {
        if (visited[idx]) {
          continue;
        }

        if (graph[minIdx][idx] == -1) {
          continue;
        }

        int newDist = dist[minIdx] + graph[minIdx][idx];
        dist[idx] = Math.min(dist[idx], newDist);
      }

    }

    return dist;
  }
}
