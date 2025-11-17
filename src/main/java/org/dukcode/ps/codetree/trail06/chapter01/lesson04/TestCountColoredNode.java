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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-count-colored-node/description">LINK</a>
 */
public class TestCountColoredNode {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static List<Integer>[] adj;
  private static int k;
  private static boolean[] colored;
  private static int q;

  private static int log;
  private static int[][] parents;
  private static int[] depths;
  private static int[] cntColoredFromRoot;

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

      adj[a].add(b);
      adj[b].add(a);
    }

    k = Integer.parseInt(br.readLine());
    colored = new boolean[n];
    for (int i = 0; i < k; i++) {
      int idx = Integer.parseInt(br.readLine()) - 1;
      colored[idx] = true;
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
    cntColoredFromRoot = new int[n];

    dfs(0, -1, 0, 0);
    buildParents();

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
    int lca = lca(a, b);
    return cntColoredFromRoot[a] + cntColoredFromRoot[b]
        - 2 * cntColoredFromRoot[lca] + (colored[lca] ? 1 : 0);
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

  private static void buildParents() {
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

  private static void dfs(int cur, int parent, int depth, int cntColored) {
    parents[cur][0] = parent;
    depths[cur] = depth;
    cntColoredFromRoot[cur] = cntColored;

    for (int next : adj[cur]) {
      if (next == parent) {
        continue;
      }

      dfs(next, cur, depth + 1, cntColored + (colored[next] ? 1 : 0));
    }
  }
}
