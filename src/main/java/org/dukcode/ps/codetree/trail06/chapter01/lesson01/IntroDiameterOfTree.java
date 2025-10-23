package org.dukcode.ps.codetree.trail06.chapter01.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-diameter-of-tree/description">LINK</a>
 */
public class IntroDiameterOfTree {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static List<Neighbor>[] adj;

  private static boolean[] vis;
  private static int[] dist;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    adj = new List[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new ArrayList<>();
    }

    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;
      int dist = Integer.parseInt(st.nextToken());
      adj[a].add(new Neighbor(b, dist));
      adj[b].add(new Neighbor(a, dist));
    }

    State pivot = findFarthest(0);
    State ans = findFarthest(pivot.idx);

    bw.write(String.valueOf(ans.dist));

    br.close();
    bw.close();
  }

  private static State findFarthest(int idx) {
    vis = new boolean[n];
    dist = new int[n];
    dfs(idx);

    int farthest = -1;
    State ret = null;
    for (int i = 0; i < n; i++) {
      if (dist[i] > farthest) {
        farthest = dist[i];
        ret = new State(i, farthest);
      }
    }

    return ret;
  }


  private static void dfs(int cur) {
    vis[cur] = true;
    for (Neighbor neighbor : adj[cur]) {
      int next = neighbor.idx;
      int nextDist = dist[cur] + neighbor.dist;

      if (vis[next]) {
        continue;
      }
      dist[next] = nextDist;
      dfs(next);
    }
  }

  private static class State {

    int idx;
    int dist;

    public State(int idx, int dist) {
      this.idx = idx;
      this.dist = dist;
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
