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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-minimum-spanning-tree-8/description">LINK</a>
 */
public class IntroMinimumSpanningTree8 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  private static List<Edge>[] adj;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    adj = new List[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;
      int w = Integer.parseInt(st.nextToken());

      adj[a].add(new Edge(b, w));
      adj[b].add(new Edge(a, w));
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.w));
    boolean[] visited = new boolean[n];

    visited[0] = true;
    for (Edge e : adj[0]) {
      pq.offer(e);
    }

    int visCnt = 1;
    int ret = 0;
    while (!pq.isEmpty()) {
      Edge e = pq.poll();

      if (visited[e.idx]) {
        continue;
      }

      visited[e.idx] = true;
      visCnt++;
      ret += e.w;

      for (Edge next : adj[e.idx]) {
        if (visited[next.idx]) {
          continue;
        }

        pq.offer(next);
      }
    }

    return visCnt == n ? ret : -1;
  }

  private static class Edge {

    int idx;
    int w;

    Edge(int idx, int w) {
      this.idx = idx;
      this.w = w;
    }
  }
}
