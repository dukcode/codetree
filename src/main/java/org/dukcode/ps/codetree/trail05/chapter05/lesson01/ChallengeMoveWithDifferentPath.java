package org.dukcode.ps.codetree.trail05.chapter05.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-move-with-different-path/description">LINK</a>
 */
public class ChallengeMoveWithDifferentPath {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int[][] adj;

  private static boolean[] pathVisited;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    adj = new int[n][n];
    for (int i = 0; i < n; ++i) {
      Arrays.fill(adj[i], -1);
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;
      int dist = Integer.parseInt(st.nextToken());

      adj[a][b] = dist;
      adj[b][a] = dist;
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    int[] distFromA = dijkstra(0);

    pathVisited = new boolean[n];
    removePath(distFromA, 0, n - 1);

    int[] distFromB = dijkstra(0);

    return distFromB[n - 1] == Integer.MAX_VALUE ? -1 : distFromB[n - 1];
  }

  private static boolean removePath(int[] dist, int cur, int dest) {
    pathVisited[cur] = true;

    if (cur == dest) {
      return true;
    }

    for (int next = 0; next < n; ++next) {
      int d = adj[cur][next];

      if (pathVisited[next]) {
        continue;
      }

      if (d == -1) {
        continue;
      }

      if (dist[cur] + d != dist[next]) {
        continue;
      }

      adj[cur][next] = -1;

      if (removePath(dist, next, dest)) {
        return true;
      }
      adj[cur][next] = d;
    }

    return false;
  }

  private static int[] dijkstra(int src) {
    boolean[] visited = new boolean[n];

    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);

    PriorityQueue<State> pq = new PriorityQueue<>();

    pq.offer(new State(src, 0));
    dist[src] = 0;

    while (!pq.isEmpty()) {
      State cur = pq.poll();
      int curIdx = cur.idx;

      if (visited[curIdx]) {
        continue;
      }

      visited[curIdx] = true;

      for (int nextIdx = 0; nextIdx < n; nextIdx++) {
        if (adj[curIdx][nextIdx] == -1) {
          continue;
        }

        int nextDist = cur.dist + adj[curIdx][nextIdx];

        if (dist[nextIdx] <= nextDist) {
          continue;
        }

        dist[nextIdx] = nextDist;
        pq.offer(new State(nextIdx, nextDist));
      }
    }

    return dist;
  }

  private static class State implements Comparable<State> {

    int idx;
    int dist;

    public State(int idx, int dist) {
      this.idx = idx;
      this.dist = dist;
    }

    @Override
    public int compareTo(State o) {
      return Integer.compare(dist, o.dist);
    }
  }


  private static class Neighbor {

    int idx;
    int dist;

    public Neighbor(int idx, int dist) {
      this.idx = idx;
      this.dist = dist;
    }

  }
}
