package org.dukcode.ps.codetree.trail06.chapter02.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-restore-tree/description">LINK</a>
 */
public class ChallengeRestoreTree {

  private static final int MX = 987_654_321;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[][] adj;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    adj = new int[n][n];
    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < n; x++) {
        adj[y][x] = Integer.parseInt(st.nextToken());
      }
    }

    int[] dists = new int[n];
    Arrays.fill(dists, MX);

    int[] distsFrom = new int[n];

    boolean[] visited = new boolean[n];
    dists[0] = 0;

    List<Edge> edges = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int from = -1;
      for (int idx = 0; idx < n; idx++) {
        if (visited[idx]) {
          continue;
        }

        if (from == -1 || dists[idx] < dists[from]) {
          from = idx;
        }

      }

      visited[from] = true;
      if (distsFrom[from] != from) {
        edges.add(new Edge(
            Math.min(distsFrom[from], from),
            Math.max(distsFrom[from], from),
            dists[from]
        ));
      }

      for (int to = 0; to < n; to++) {
        if (dists[to] > adj[from][to]) {
          dists[to] = adj[from][to];
          distsFrom[to] = from;
        }
      }
    }

    edges.sort((e1, e2) -> e1.from == e2.from ? e1.to - e2.to : e1.from - e2.from);

    for (Edge edge : edges) {
      bw.write(String.valueOf(edge.from + 1));
      bw.write(' ');
      bw.write(String.valueOf(edge.to + 1));
      bw.write(' ');
      bw.write(String.valueOf(edge.dist));
      bw.newLine();
    }

    br.close();
    bw.close();
  }

  private static class Edge {

    int from;
    int to;
    int dist;

    public Edge(int from, int to, int dist) {
      this.from = from;
      this.to = to;
      this.dist = dist;
    }
  }
}
