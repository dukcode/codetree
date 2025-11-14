package org.dukcode.ps.codetree.trail06.chapter01.lesson04;

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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-adjacent-common-ancestor-nodes/description">LINK</a>
 */
public class IntroAdjacentCommonAncestorNodes {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static List<Integer>[] children;

  private static int a;
  private static int b;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    children = new List[n];
    for (int i = 0; i < n; i++) {
      children[i] = new ArrayList<>();
    }

    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int parent = Integer.parseInt(st.nextToken()) - 1;
      int child = Integer.parseInt(st.nextToken()) - 1;

      children[parent].add(child);
    }

    st = new StringTokenizer(br.readLine());
    a = Integer.parseInt(st.nextToken()) - 1;
    b = Integer.parseInt(st.nextToken()) - 1;

    bw.write(String.valueOf(solve() + 1));

    br.close();
    bw.close();
  }

  private static int solve() {
    int root = findRoot();

    int[] depth = new int[n];
    int[] parent = new int[n];

    dfs(root, 0, depth, parent);

    return findLca(a, b, depth, parent);
  }

  private static int findLca(int a, int b, int[] depth, int[] parent) {
    if (depth[a] == depth[b]) {
      return a == b ? a : findLca(parent[a], parent[b], depth, parent);
    }

    if (depth[a] > depth[b]) {
      return findLca(parent[a], b, depth, parent);
    } else {
      return findLca(a, parent[b], depth, parent);
    }
  }

  private static void dfs(int cur, int depthNow, int[] depth, int[] parent) {

    depth[cur] = depthNow;
    for (int child : children[cur]) {
      parent[child] = cur;
      dfs(child, depthNow + 1, depth, parent);
    }
  }

  private static int findRoot() {
    int[] inbounds = new int[n];
    for (int parent = 0; parent < n; parent++) {
      for (int child : children[parent]) {
        inbounds[child]++;
      }
    }

    for (int idx = 0; idx < n; ++idx) {
      if (inbounds[idx] == 0) {
        return idx;
      }
    }

    return -1;
  }
}
