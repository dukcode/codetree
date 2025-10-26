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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-dot-to-the-dot/description">LINK</a>
 */
public class ChallengeDotToTheDot {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int x;

  private static List<Neighbor>[] adj;
  private static List<Integer> cList;

  private static int[] dist;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());

    adj = new List[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new ArrayList<>();
    }

    cList = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;
      int l = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      adj[a].add(new Neighbor(b, l, c));
      adj[b].add(new Neighbor(a, l, c));

      cList.add(c);
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    double ans = Double.MAX_VALUE;
    for (int minC : cList) {
      dist = new int[n];
      Arrays.fill(dist, Integer.MAX_VALUE);

      dijkstra(0, minC);
      if (dist[n - 1] == Integer.MAX_VALUE) {
        continue;
      }
      ans = Math.min(ans, dist[n - 1] + (double) x / minC);
    }

    return (int) ans;
  }

  private static void dijkstra(int start, int minC) {
    boolean[] visited = new boolean[n];

    PriorityQueue<State> pq = new PriorityQueue<>();

    dist[start] = 0;
    pq.offer(new State(start, 0));

    while (!pq.isEmpty()) {
      State curState = pq.poll();
      int curIdx = curState.idx;

      if (visited[curIdx]) {
        continue;
      }

      visited[curIdx] = true;

      for (Neighbor next : adj[curIdx]) {
        int nextIdx = next.idx;

        if (next.c < minC) {
          continue;
        }

        int nextDist = curState.dist + next.l;
        if (dist[nextIdx] <= nextDist) {
          continue;
        }

        dist[nextIdx] = nextDist;
        pq.offer(new State(nextIdx, nextDist));
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
      return this.dist - o.dist;
    }
  }

  private static class Neighbor {

    int idx;
    int l;
    int c;

    public Neighbor(int idx, int l, int c) {
      this.idx = idx;
      this.l = l;
      this.c = c;
    }

  }
}
