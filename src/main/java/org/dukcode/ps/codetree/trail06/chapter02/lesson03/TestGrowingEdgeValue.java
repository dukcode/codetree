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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-growing-edge-value/description">LINK</a>
 */
public class TestGrowingEdgeValue {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int k;

  private static List<Edge>[] adj;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    adj = new List[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;
      long w = Long.parseLong(st.nextToken());

      adj[a].add(new Edge(b, w));
      adj[b].add(new Edge(a, w));
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static long solve() {
    boolean[] visited = new boolean[n];

    PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingLong(e -> e.w));

    visited[0] = true;
    for (Edge e : adj[0]) {
      pq.offer(e);
    }

    long additional = 0L;

    long ret = 0L;
    while (!pq.isEmpty()) {
      Edge cur = pq.poll();
      int curIdx = cur.idx;

      if (visited[curIdx]) {
        continue;
      }

      visited[curIdx] = true;
      ret += cur.w + additional;
      additional += k;

      for (Edge next : adj[curIdx]) {
        int nextIdx = next.idx;
        if (visited[nextIdx]) {
          continue;
        }

        pq.offer(next);
      }

    }

    return ret;
  }

  private static class Edge {

    int idx;
    long w;

    public Edge(int idx, long w) {
      this.idx = idx;
      this.w = w;
    }

  }

}
