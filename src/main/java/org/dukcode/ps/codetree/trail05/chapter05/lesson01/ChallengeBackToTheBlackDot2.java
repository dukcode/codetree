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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-back-to-the-black-dot-2/description">LINK</a>
 */
public class ChallengeBackToTheBlackDot2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int r1;
  private static int r2;
  private static List<Neighbor>[] adj;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    r1 = Integer.parseInt(st.nextToken()) - 1;
    r2 = Integer.parseInt(st.nextToken()) - 1;

    adj = new List[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;
      int dist = Integer.parseInt(st.nextToken());

      adj[a].add(new Neighbor(b, dist));
      adj[b].add(new Neighbor(a, dist));
    }

    int[] distFromR1 = dijkstra(r1);
    int[] distFromR2 = dijkstra(r2);

    int ans = Integer.MAX_VALUE;
    for (int idx = 0; idx < n; ++idx) {
      if (idx == r1 || idx == r2) {
        continue;
      }

      if (distFromR1[idx] == Integer.MAX_VALUE || distFromR2[idx] == Integer.MAX_VALUE) {
        continue;
      }

      ans = Math.min(ans, distFromR1[idx] + distFromR2[idx] + distFromR1[r2]);
    }

    bw.write(String.valueOf(ans == Integer.MAX_VALUE ? -1 : ans));

    br.close();
    bw.close();
  }

  private static int[] dijkstra(int start) {
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[start] = 0;

    boolean[] visited = new boolean[n];

    PriorityQueue<State> pq = new PriorityQueue<>();
    pq.offer(new State(start, 0));

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
