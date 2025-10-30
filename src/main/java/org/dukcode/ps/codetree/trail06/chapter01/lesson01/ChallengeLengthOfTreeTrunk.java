package org.dukcode.ps.codetree.trail06.chapter01.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-length-of-tree-trunk/description">LINK</a>
 */
public class ChallengeLengthOfTreeTrunk {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static List<State>[] adj;

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

      adj[a].add(new State(b, dist));
      adj[b].add(new State(a, dist));
    }

    dist = new int[n];
    Arrays.fill(dist, -1);
    dfs(0, 0);

    int longestDist = -1;
    int start = -1;
    for (int i = 0; i < n; i++) {
      if (dist[i] <= longestDist) {
        continue;
      }

      longestDist = dist[i];
      start = i;
    }

    dist = new int[n];
    Arrays.fill(dist, -1);
    dfs(start, 0);

    longestDist = -1;
    for (int i = 0; i < n; i++) {
      if (dist[i] <= longestDist) {
        continue;
      }

      longestDist = dist[i];
    }

    bw.write(String.valueOf(longestDist));

    br.close();
    bw.close();
  }

  private static void dfs(int cur, int distNow) {
    dist[cur] = distNow;

    for (State next : adj[cur]) {
      if (dist[next.idx] != -1) {
        continue;
      }

      dfs(next.idx, distNow + next.dist);
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
}
