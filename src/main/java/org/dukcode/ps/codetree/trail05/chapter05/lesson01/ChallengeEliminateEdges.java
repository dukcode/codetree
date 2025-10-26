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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-eliminate-edges/description">LINK</a>
 */
public class ChallengeEliminateEdges {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  private static int[][] adj;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    adj = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(adj[i], Integer.MAX_VALUE);
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
    int[] distFromStart = dijkstra(0);
    int[] distFromEnd = dijkstra(n - 1);

    int ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (adj[i][j] == Integer.MAX_VALUE) {
          continue;
        }

        if (distFromStart[i] == Integer.MAX_VALUE || distFromEnd[j] == Integer.MAX_VALUE) {
          continue;
        }

        if (distFromStart[n - 1] != distFromStart[i] + adj[i][j] + distFromEnd[j]) {
          continue;
        }

        int distBefore = adj[i][j];
        adj[i][j] = Integer.MAX_VALUE;
        adj[j][i] = Integer.MAX_VALUE;

        if (distFromStart[n - 1] != dijkstra(0)[n - 1]) {
          ans++;
        }

        adj[i][j] = distBefore;
        adj[j][i] = distBefore;
      }
    }

    return ans;
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
        int d = adj[curIdx][nextIdx];

        if (d == Integer.MAX_VALUE) {
          continue;
        }

        int nextDist = cur.dist + d;
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
