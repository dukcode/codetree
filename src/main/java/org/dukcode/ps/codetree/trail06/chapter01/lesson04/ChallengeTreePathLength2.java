package org.dukcode.ps.codetree.trail06.chapter01.lesson04;

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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-tree-path-length-2/description">LINK</a>
 */
public class ChallengeTreePathLength2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static List<Edge>[] adj;
  private static int q;

  private static int log;
  private static int[][] parents;
  private static int[] depths;
  private static int[] weightsFromRoot;

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
      int w = Integer.parseInt(st.nextToken());

      adj[a].add(new Edge(b, w));
      adj[b].add(new Edge(a, w));
    }

    log = 0;
    while ((1 << log) <= n) {
      log++;
    }

    parents = new int[n][log];
    for (int i = 0; i < n; i++) {
      Arrays.fill(parents[i], -1);
    }

    depths = new int[n];

    weightsFromRoot = new int[n];

    dfs(0, -1, 0, 0);
    buildParentsTable();

    q = Integer.parseInt(br.readLine());
    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;

      bw.write(String.valueOf(solve(a, b)));
      bw.newLine();
    }

    br.close();
    bw.close();
  }

  private static int solve(int a, int b) {
    return weightsFromRoot[a] + weightsFromRoot[b] - 2 * weightsFromRoot[lca(a, b)];
  }

  private static int lca(int a, int b) {
    if (depths[a] < depths[b]) {
      return lca(b, a);
    }

    int diff = depths[a] - depths[b];
    for (int k = 0; k < log; ++k) {
      if (((diff >> k) & 1) == 1) {
        a = parents[a][k];
      }
    }

    if (a == b) {
      return a;
    }

    for (int k = log - 1; k >= 0; --k) {
      if (parents[a][k] != parents[b][k]) {
        a = parents[a][k];
        b = parents[b][k];
      }
    }

    return parents[a][0];
  }

  private static void buildParentsTable() {
    for (int k = 1; k < log; ++k) {
      for (int idx = 0; idx < n; ++idx) {
        int halfAncestor = parents[idx][k - 1];

        if (halfAncestor == -1) {
          continue;
        }

        parents[idx][k] = parents[halfAncestor][k - 1];
      }
    }
  }

  private static void dfs(int cur, int parent, int depth, int weight) {
    weightsFromRoot[cur] = weight;
    depths[cur] = depth;
    parents[cur][0] = parent;

    for (Edge next : adj[cur]) {
      if (next.to == parent) {
        continue;
      }

      dfs(next.to, cur, depth + 1, weight + next.w);
    }
  }

  private static class Edge {

    int to;
    int w;

    public Edge(int to, int w) {
      this.to = to;
      this.w = w;
    }
  }
}
