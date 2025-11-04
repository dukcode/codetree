package org.dukcode.ps.codetree.trail06.chapter01.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-modify-tree/description">LINK</a>
 */
public class ChallengeModifyTree {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static List<Edge>[] adj;
  private static Edge[] edges;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    adj = new List[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new ArrayList<>();
    }

    edges = new Edge[n - 1];
    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int dist = Integer.parseInt(st.nextToken());

      adj[a].add(new Edge(a, b, dist));
      adj[b].add(new Edge(b, a, dist));
      edges[i] = new Edge(Math.min(a, b), Math.max(b, a), dist);
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    int ret = 0;

    for (int toRemove = 0; toRemove < n - 1; toRemove++) {
      int x = edges[toRemove].from;
      int y = edges[toRemove].to;
      int dist = edges[toRemove].dist;

      ret = Math.max(ret, dist + diameter(x, edges[toRemove]) + diameter(y, edges[toRemove]));
    }

    return ret;
  }

  private static int diameter(int x, Edge removeEdge) {
    Path a = dfs(x, 0, removeEdge, new boolean[n]);
    Path b = dfs(a.idx, 0, removeEdge, new boolean[n]);
    return b.dist;
  }

  private static Path dfs(int hereIdx, int dist, Edge removeEdge, boolean[] visited) {
    visited[hereIdx] = true;

    int retIdx = hereIdx;
    int retDist = dist;
    for (Edge next : adj[hereIdx]) {
      int nextIdx = next.to;

      if (Math.min(hereIdx, nextIdx) == removeEdge.from
          && Math.max(hereIdx, nextIdx) == removeEdge.to) {
        continue;
      }

      if (visited[nextIdx]) {
        continue;
      }

      Path nextPath = dfs(nextIdx, dist + next.dist, removeEdge, visited);

      if (nextPath.dist > retDist) {
        retIdx = nextPath.idx;
        retDist = nextPath.dist;
      }
    }

    return new Path(retIdx, retDist);
  }

  private static class Path {

    int idx;
    int dist;

    public Path(int idx, int dist) {
      this.idx = idx;
      this.dist = dist;
    }
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
