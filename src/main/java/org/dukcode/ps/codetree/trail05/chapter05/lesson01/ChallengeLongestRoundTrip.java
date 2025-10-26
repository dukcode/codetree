package org.dukcode.ps.codetree.trail05.chapter05.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-longest-round-trip/description">LINK</a>
 */
public class ChallengeLongestRoundTrip {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int x;

  private static List<Neighbor>[] adj;
  private static List<Neighbor>[] adjReverse;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken()) - 1;

    adj = new List[n];
    adjReverse = new List[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new ArrayList<>();
      adjReverse[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int fr = Integer.parseInt(st.nextToken()) - 1;
      int to = Integer.parseInt(st.nextToken()) - 1;
      int dist = Integer.parseInt(st.nextToken());

      adj[fr].add(new Neighbor(to, dist));
      adjReverse[to].add(new Neighbor(fr, dist));
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    int[] dist = dijkstra(x, adj);
    int[] distReverse = dijkstra(x, adjReverse);

    int ans = -1;
    for (int idx = 0; idx < n; idx++) {
      if (idx == x) {
        continue;
      }

      if (dist[idx] == Integer.MAX_VALUE || distReverse[idx] == Integer.MAX_VALUE) {
        continue;
      }

      ans = Math.max(ans, dist[idx] + distReverse[idx]);
    }

    return ans;
  }

  private static int[] dijkstra(int src, List<Neighbor>[] adj) {
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

      for (Neighbor next : adj[curIdx]) {
        int nextIdx = next.idx;
        int nextDist = cur.dist + next.dist;

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
