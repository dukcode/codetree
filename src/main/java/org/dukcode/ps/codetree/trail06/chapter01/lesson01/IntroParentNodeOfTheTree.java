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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-parent-node-of-the-tree/description">LINK</a>
 */
public class IntroParentNodeOfTheTree {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static List<Integer>[] adj;

  private static boolean[] vis;
  private static int[] parent;

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

    parent = new int[n];
    Arrays.fill(parent, -1);

    vis = new boolean[n];

    dfs(0);

    for (int i = 1; i < n; ++i) {
      bw.write(String.valueOf(parent[i] + 1));
      bw.newLine();
    }

    br.close();
    bw.close();
  }

  private static void dfs(int v) {
    vis[v] = true;

    for (int child : adj[v]) {
      if (vis[child]) {
        continue;
      }

      parent[child] = v;
      dfs(child);
    }
  }
}
