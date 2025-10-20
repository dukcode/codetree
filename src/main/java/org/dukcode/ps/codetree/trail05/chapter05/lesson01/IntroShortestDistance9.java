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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-shortest-distance-9/description">LINK</a>
 */
public class IntroShortestDistance9 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static List<Neighbor>[] adj;

  private static int a;
  private static int b;

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
      int v1 = Integer.parseInt(st.nextToken()) - 1;
      int v2 = Integer.parseInt(st.nextToken()) - 1;
      int dist = Integer.parseInt(st.nextToken());

      adj[v1].add(new Neighbor(v2, dist));
      adj[v2].add(new Neighbor(v1, dist));
    }

    st = new StringTokenizer(br.readLine());
    a = Integer.parseInt(st.nextToken()) - 1;
    b = Integer.parseInt(st.nextToken()) - 1;

    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);

    int[] parent = new int[n];
    Arrays.fill(parent, -1);

    solve(dist, parent);

    bw.write(String.valueOf(dist[b]));
    bw.newLine();

    printPath(b, parent);

    br.close();
    bw.close();
  }

  private static void printPath(int now, int[] parent) throws IOException {
    if (now == a) {
      bw.write(String.valueOf(a + 1));
      bw.write(' ');
      return;
    }

    printPath(parent[now], parent);

    bw.write(String.valueOf(now + 1));
    bw.write(' ');
  }

  private static void solve(int[] dist, int[] parent) {
    boolean[] visited = new boolean[n];

    PriorityQueue<State> pq = new PriorityQueue<>();
    pq.offer(new State(a, 0));

    dist[a] = 0;

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
        parent[next.idx] = cur.idx;
        pq.offer(new State(next.idx, nextDist));
      }
    }
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
