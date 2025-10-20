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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-longest-student-2/description">LINK</a>
 */
public class IntroLongestStudent2 {

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
    for (int i = 0; i < n; i++) {
      adj[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken()) - 1;
      int to = Integer.parseInt(st.nextToken()) - 1;
      int dist = Integer.parseInt(st.nextToken());

      adj[to].add(new Neighbor(from, dist)); // 뒤집기
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    int[] dist = dijkstra(n - 1);

    int ret = -1;
    for (int i = 0; i < n; i++) {
      ret = Math.max(ret, dist[i]);
    }

    return ret;
  }

  private static int[] dijkstra(int start) {
    boolean[] visited = new boolean[n];

    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);

    PriorityQueue<State> pq = new PriorityQueue<>();

    pq.offer(new State(start, 0));
    dist[start] = 0;

    while (!pq.isEmpty()) {
      State cur = pq.poll();

      if (visited[cur.idx]) {
        continue;
      }

      visited[cur.idx] = true;

      for (Neighbor next : adj[cur.idx]) {
        int nextDist = cur.dist + next.dist;

        if (dist[next.idx] <= nextDist) {
          continue;
        }

        dist[next.idx] = nextDist;
        pq.offer(new State(next.idx, nextDist));
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
      return Integer.compare(this.dist, o.dist);
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
