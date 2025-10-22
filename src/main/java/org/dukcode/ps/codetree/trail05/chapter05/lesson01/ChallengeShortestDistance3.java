package org.dukcode.ps.codetree.trail05.chapter05.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-shortest-distance-3/description">LINK</a>
 */
public class ChallengeShortestDistance3 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static long[][] adj;

  private static int a;
  private static int b;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    adj = new long[n][n];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;
      long dist = Long.parseLong(st.nextToken());

      adj[a][b] = adj[a][b] == 0 ? dist : Math.min(adj[a][b], dist);
      adj[b][a] = adj[b][a] == 0 ? dist : Math.min(adj[b][a], dist);
    }

    st = new StringTokenizer(br.readLine());
    a = Integer.parseInt(st.nextToken()) - 1;
    b = Integer.parseInt(st.nextToken()) - 1;

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static long solve() {
    long[] dist = dijkstra(a);

    return dist[b];
  }

  private static long[] dijkstra(int start) {
    long[] dist = new long[n];
    Arrays.fill(dist, Long.MAX_VALUE);

    boolean[] visited = new boolean[n];

    PriorityQueue<State> pq = new PriorityQueue<>(
        Comparator.comparingLong(state -> state.stateDist));

    pq.offer(new State(start, 0));
    dist[start] = 0;

    while (!pq.isEmpty()) {
      State curState = pq.poll();

      if (curState.idx == b) {
        break;
      }

      if (visited[curState.idx]) {
        continue;
      }

      visited[curState.idx] = true;

      int curIdx = curState.idx;
      long curStateDist = curState.stateDist;
      for (int nextIdx = 0; nextIdx < n; nextIdx++) {
        if (adj[curIdx][nextIdx] == 0) {
          continue;
        }

        long nextStateDist = curStateDist + adj[curIdx][nextIdx];

        if (dist[nextIdx] <= nextStateDist) {
          continue;
        }

        dist[nextIdx] = nextStateDist;
        pq.offer(new State(nextIdx, nextStateDist));
      }

    }

    return dist;
  }

  private static class State {

    int idx;
    long stateDist;

    public State(int idx, long stateDist) {
      this.idx = idx;
      this.stateDist = stateDist;
    }
  }
}
