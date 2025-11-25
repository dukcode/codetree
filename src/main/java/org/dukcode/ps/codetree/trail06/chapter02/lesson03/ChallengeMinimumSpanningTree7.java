package org.dukcode.ps.codetree.trail06.chapter02.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-minimum-spanning-tree-7/description">LINK</a>
 */
public class ChallengeMinimumSpanningTree7 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static List<Edge>[] adj;

  private static List<Edge>[] mst;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    adj = new List[n];
    mst = new List[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new ArrayList<>();
      mst[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;
      int w = Integer.parseInt(st.nextToken());

      adj[a].add(new Edge(a, b, w));
      adj[b].add(new Edge(b, a, w));
    }

    int totalWeight = prim();

    bw.write(String.valueOf(totalWeight));
    bw.newLine();
    bw.write(String.valueOf(longestPath()));
    bw.newLine();

    br.close();
    bw.close();
  }

  private static int longestPath() {
    int[] a = dfs(0, -1, 0);
    int aIdx = a[0];
    int[] ret = dfs(aIdx, -1, 0);
    return ret[1];
  }

  private static int[] dfs(int cur, int parent, int dist) {

    int[] ret = new int[]{cur, dist};
    for (Edge next : mst[cur]) {
      if (next.to == parent) {
        continue;
      }

      int[] nextResult = dfs(next.to, cur, dist + next.w);

      if (ret[1] < nextResult[1]) {
        ret[0] = nextResult[0];
        ret[1] = nextResult[1];
      }
    }

    return ret;
  }

  private static int prim() {
    boolean[] visited = new boolean[n];
    PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.w));

    visited[0] = true;
    for (Edge edge : adj[0]) {
      pq.offer(edge);
    }

    int totalWeight = 0;
    while (!pq.isEmpty()) {
      Edge cur = pq.poll();
      int curIdx = cur.to;
      int curWeight = cur.w;

      if (visited[curIdx]) {
        continue;
      }

      visited[curIdx] = true;
      totalWeight += curWeight;
      mst[cur.from].add(new Edge(cur.from, cur.to, cur.w));
      mst[cur.to].add(new Edge(cur.to, cur.from, cur.w));

      for (Edge next : adj[curIdx]) {
        int nextIdx = next.to;

        if (visited[nextIdx]) {
          continue;
        }

        pq.offer(next);
      }
    }
    return totalWeight;
  }

  private static class Edge {

    int from;
    int to;
    int w;

    public Edge(int from, int to, int w) {
      this.from = from;
      this.to = to;
      this.w = w;
    }
  }
}
