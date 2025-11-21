package org.dukcode.ps.codetree.trail06.chapter03.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-height-of-friends/description">LINK</a>
 */
public class IntroHeightOfFriends {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static List<Integer>[] adj;

  private static boolean[] visited;
  private static List<Integer> order;

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
    }

    List<Integer> ans = solve();
    for (Integer idx : ans) {
      bw.write(String.valueOf(idx + 1));
      bw.write(' ');
    }

    br.close();
    bw.close();
  }

  private static List<Integer> solve() {
    visited = new boolean[n];
    order = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      if (visited[i]) {
        continue;
      }

      dfs(i);
    }

    Collections.reverse(order);
    return order;
  }

  private static void dfs(int cur) {
    visited[cur] = true;

    for (int next : adj[cur]) {
      if (visited[next]) {
        continue;
      }

      dfs(next);
    }

    order.add(cur);
  }
}
