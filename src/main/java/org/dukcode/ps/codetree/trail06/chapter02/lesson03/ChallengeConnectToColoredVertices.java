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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-connect-to-colored-vertices/description">LINK</a>
 */
public class ChallengeConnectToColoredVertices {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int k;

  private static int[] starts;
  private static List<Edge>[] adj;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    starts = new int[k];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < k; i++) {
      starts[i] = Integer.parseInt(st.nextToken()) - 1;
    }

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

    boolean[] visited = new boolean[n];

    PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.w));

    for (int start : starts) {
      visited[start] = true;
      for (Edge edge : adj[start]) {
        pq.offer(edge);
      }
    }

    int ret = 0;
    while (!pq.isEmpty()) {
      Edge cur = pq.poll();
      int curIdx = cur.idx;
      int curW = cur.w;

      if (visited[curIdx]) {
        continue;
      }

      visited[curIdx] = true;
      ret += curW;

      for (Edge next : adj[curIdx]) {
        int nextIdx = next.idx;

        if (visited[nextIdx]) {
          continue;
        }

        pq.offer(next);
      }
    }

    bw.write(String.valueOf(ret));

    br.close();
    bw.close();
  }

  private static class Edge {

    int idx;
    int w;

    public Edge(int idx, int w) {
      this.idx = idx;
      this.w = w;
    }
  }
}
