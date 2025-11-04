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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-graphs-and-trees/description">LINK</a>
 */
public class TestGraphsAndTrees {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static List<Integer>[] adj;

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
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;

      adj[a].add(b);
      adj[b].add(a);
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    boolean[] visited = new boolean[n];

    int ret = 0;
    for (int idx = 0; idx < n; idx++) {
      if (visited[idx]) {
        continue;
      }

      if (!hasCycle(idx, visited, -1)) {
        ret++;
      }
    }

    return ret;
  }

  private static boolean hasCycle(int here, boolean[] visited, int before) {
    visited[here] = true;

    boolean ret = false;
    for (int there : adj[here]) {

      if (there == before) {
        continue;
      }

      if (visited[there]) {
        ret = true;
        continue;
      }

      ret |= hasCycle(there, visited, here);
    }

    return ret;
  }
}
