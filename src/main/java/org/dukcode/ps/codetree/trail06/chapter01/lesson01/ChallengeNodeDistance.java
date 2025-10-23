package org.dukcode.ps.codetree.trail06.chapter01.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-node-distance/description">LINK</a>
 */
public class ChallengeNodeDistance {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  private static int[][] adj;
  private static int[][] dist;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    adj = new int[n][n];
    for (int y = 0; y < n; y++) {
      Arrays.fill(adj[y], -1);
      adj[y][y] = 0;
    }

    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;
      int dist = Integer.parseInt(st.nextToken());

      adj[a][b] = dist;
      adj[b][a] = dist;
    }

    dist = new int[n][n];
    dfsAll();

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;

      bw.write(String.valueOf(dist[a][b]));
      bw.newLine();
    }

    br.close();
    bw.close();
  }

  private static void dfsAll() {
    for (int start = 0; start < n; start++) {
      boolean[] visited = new boolean[n];
      dfs(start, start, visited, 0);
    }
  }

  private static void dfs(int start, int cur, boolean[] visited, int pathDist) {
    visited[cur] = true;
    dist[start][cur] = pathDist;

    for (int next = 0; next < n; next++) {
      if (visited[next]) {
        continue;
      }

      if (adj[cur][next] == -1) {
        continue;
      }

      dfs(start, next, visited, pathDist + adj[cur][next]);
    }
  }
}
