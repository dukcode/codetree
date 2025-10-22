package org.dukcode.ps.codetree.trail05.chapter05.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-shortest-distance-11/description">LINK</a>
 */
public class IntroShortestDistance11 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static List<Neighbor>[] adj;

  private static int a;
  private static int b;

  private static long[] distFromA;
  private static long[] distFromB;

  private static long minCost;
  private static boolean[] pathVisited;
  private static boolean found;
  private static List<Integer> path;

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
      long dist = Long.parseLong(st.nextToken());

      adj[v1].add(new Neighbor(v2, dist));
      adj[v2].add(new Neighbor(v1, dist));
    }

    for (int i = 0; i < n; ++i) {
      Collections.sort(adj[i]);
    }

    st = new StringTokenizer(br.readLine());
    a = Integer.parseInt(st.nextToken()) - 1;
    b = Integer.parseInt(st.nextToken()) - 1;

    distFromA = dijkstra(a);
    distFromB = dijkstra(b);

    minCost = distFromA[b];
    pathVisited = new boolean[n];
    path = new ArrayList<>();

    path.add(a);
    findPath(a, path);

    bw.write(String.valueOf(minCost));
    bw.newLine();
    for (Integer idx : path) {
      bw.write(String.valueOf(idx + 1));
      bw.write(' ');
    }

    br.close();
    bw.close();
  }

  private static boolean findPath(int nowIdx, List<Integer> path) {
    pathVisited[nowIdx] = true;

    if (nowIdx == b) {
      return true;
    }

    for (Neighbor next : adj[nowIdx]) {
      int nextIdx = next.idx;
      long dist = next.dist;

      if (pathVisited[nextIdx]) {
        continue;
      }

      if (distFromA[nowIdx] + dist != distFromA[nextIdx]) {
        continue;
      }

      path.add(nextIdx);

      if (findPath(nextIdx, path)) {
        return true;
      }

      path.remove(path.size() - 1);
    }

    return false;
  }

  private static long[] dijkstra(int start) {
    long[] dist = new long[n];
    Arrays.fill(dist, Long.MAX_VALUE);

    boolean[] vis = new boolean[n];

    PriorityQueue<State> pq = new PriorityQueue<>();

    pq.offer(new State(start, 0));
    dist[start] = 0;

    while (!pq.isEmpty()) {
      State curState = pq.poll();

      if (vis[curState.idx]) {
        continue;
      }

      vis[curState.idx] = true;

      for (Neighbor next : adj[curState.idx]) {
        long nextStateDist = curState.dist + next.dist;

        if (dist[next.idx] <= nextStateDist) {
          continue;
        }

        dist[next.idx] = nextStateDist;
        pq.offer(new State(next.idx, nextStateDist));
      }
    }

    return dist;
  }

  private static class State implements Comparable<State> {

    int idx;
    long dist;

    public State(int idx, long dist) {
      this.idx = idx;
      this.dist = dist;
    }

    @Override
    public int compareTo(State o) {
      return Long.compare(this.dist, o.dist);
    }
  }

  private static class Neighbor implements Comparable<Neighbor> {

    int idx;
    long dist;

    public Neighbor(int idx, long dist) {
      this.idx = idx;
      this.dist = dist;
    }

    @Override
    public int compareTo(Neighbor o) {
      return Integer.compare(this.idx, o.idx);
    }
  }
}
