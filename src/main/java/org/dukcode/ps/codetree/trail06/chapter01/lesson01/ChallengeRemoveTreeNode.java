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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-remove-tree-node/description">LINK</a>
 */
public class ChallengeRemoveTreeNode {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] parent;
  private static int toRemove;

  private static List<Integer>[] adj;

  private static boolean[] vis;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    parent = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      parent[i] = Integer.parseInt(st.nextToken());
    }

    toRemove = Integer.parseInt(br.readLine());

    adj = new List[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new ArrayList<>();
    }

    int root = -1;
    for (int i = 0; i < n; ++i) {
      if (parent[i] == -1) {
        root = i;
        continue;
      }
      adj[parent[i]].add(i);
    }

    vis = new boolean[n];
    bw.write(String.valueOf(solve(root, toRemove)));

    br.close();
    bw.close();
  }

  private static int solve(int root, int toRemove) {
    if (root == toRemove) {
      return 0;
    }

    return dfs(root, toRemove);
  }

  private static int dfs(int cur, int toRemove) {
    vis[cur] = true;

    int ret = 0;
    boolean hasChild = false;
    for (int next : adj[cur]) {
      if (!vis[next] && next != toRemove) {
        ret += dfs(next, toRemove);
        hasChild = true;
      }
    }

    if (!hasChild) {
      return 1;
    }

    return ret;
  }


}
