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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-minimum-spanning-tree-9/description">LINK</a>
 */
public class IntroMinimumSpanningTree9 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  private static List<Neighbor>[] adj;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    adj = new List[n];
    for (int i = 0; i < n; ++i) {
      adj[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;
      int w = Integer.parseInt(st.nextToken());

      adj[a].add(new Neighbor(b, w));
      adj[b].add(new Neighbor(a, w));
    }

    bw.write(String.valueOf(prim()));

    br.close();
    bw.close();
  }

  private static int prim() {
    boolean[] visited = new boolean[n];
    PriorityQueue<Neighbor> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.w));

    visited[0] = true;
    for (Neighbor n : adj[0]) {
      pq.offer(n);
    }

    int ret = 0;
    int visCnt = 1;
    while (!pq.isEmpty()) {
      Neighbor cur = pq.poll();
      if (visited[cur.toIdx]) {
        continue;
      }

      visited[cur.toIdx] = true;
      visCnt++;
      ret += cur.w;

      for (Neighbor next : adj[cur.toIdx]) {
        if (visited[next.toIdx]) {
          continue;
        }

        pq.offer(next);
      }
    }

    return visCnt == n ? ret : -1;
  }

  private static class Neighbor {

    int toIdx;
    int w;

    public Neighbor(int toIdx, int w) {
      this.toIdx = toIdx;
      this.w = w;
    }
  }
}
