package org.dukcode.ps.codetree.trail06.chapter01.lesson03;

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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-node-best-count-2/description">LINK</a>
 */
public class TestNodeBestCount2 {

  private static final int MX = 987_654_321;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static List<Integer>[] adj;

  private static boolean[] selected;

  private static int[][] cache;

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

    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;

      adj[a].add(b);
      adj[b].add(a);
    }

    selected = new boolean[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      int idx = Integer.parseInt(st.nextToken()) - 1;
      selected[idx] = true;
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    cache = new int[n][2];
    for (int i = 0; i < n; i++) {
      Arrays.fill(cache[i], -1);
    }

    return Math.min(dfs(0, -1, 0), dfs(0, -1, 1));
  }

  private static int dfs(int cur, int parent, int toSelect) {
    if (cache[cur][toSelect] != -1) {
      return cache[cur][toSelect];
    }

    if (selected[cur] && toSelect == 0) {
      return cache[cur][toSelect] = MX;
    }

    int ret = 0;
    if (toSelect == 1) {
      ret += selected[cur] ? 0 : 1;
    }

    for (int next : adj[cur]) {
      if (next == parent) {
        continue;
      }

      if (toSelect == 1) {
        ret += Math.min(dfs(next, cur, 0), dfs(next, cur, 1));
      } else {
        ret += dfs(next, cur, 1);
      }
    }

    if (ret >= MX) {
      ret = MX;
    }

    return cache[cur][toSelect] = ret;
  }
}
