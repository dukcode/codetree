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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-maximum-of-nearest-distance/description">LINK</a>
 */
public class ChallengeMaximumOfNearestDistance {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  private static int a;
  private static int b;
  private static int c;

  private static List<Neighbor>[] adj;


  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    a = Integer.parseInt(st.nextToken()) - 1;
    b = Integer.parseInt(st.nextToken()) - 1;
    c = Integer.parseInt(st.nextToken()) - 1;

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

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    int[] dist = dijkstra();

    int ret = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      ret = Math.max(ret, dist[i]);
    }

    return ret;
  }

  public static int[] dijkstra() {
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);

    boolean[] visited = new boolean[n];

    PriorityQueue<State> pq = new PriorityQueue<>();

    dist[a] = 0;
    dist[b] = 0;
    dist[c] = 0;
    pq.offer(new State(a, 0));
    pq.offer(new State(b, 0));
    pq.offer(new State(c, 0));

    while (!pq.isEmpty()) {
      State curState = pq.poll();

      int curIdx = curState.idx;
      int curStateDist = curState.dist;

      if (visited[curIdx]) {
        continue;
      }

      visited[curIdx] = true;

      for (Neighbor next : adj[curIdx]) {
        int nextIdx = next.idx;
        int nextStateDist = curStateDist + next.dist;

        if (dist[nextIdx] <= nextStateDist) {
          continue;
        }

        dist[nextIdx] = nextStateDist;
        pq.offer(new State(nextIdx, nextStateDist));
      }
    }

    return dist;
  }

  public static class Neighbor {

    int idx;
    int dist;

    public Neighbor(int idx, int dist) {
      this.idx = idx;
      this.dist = dist;
    }
  }

  public static class State implements Comparable<State> {

    int idx;
    int dist;

    public State(int idx, int dist) {
      this.idx = idx;
      this.dist = dist;
    }

    @Override
    public int compareTo(State o) {
      return Integer.compare(this.dist, o.dist);
    }
  }
}
