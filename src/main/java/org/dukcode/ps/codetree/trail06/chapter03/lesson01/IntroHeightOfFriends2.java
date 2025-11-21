package org.dukcode.ps.codetree.trail06.chapter03.lesson01;

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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-height-of-friends-2/description">LINK</a>
 */
public class IntroHeightOfFriends2 {

  private static final int NOT_VISITED = 0;
  private static final int VISITING = 1;
  private static final int VISITED = 2;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  private static List<Integer>[] adj;

  private static int[] visited;

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
      int before = Integer.parseInt(st.nextToken()) - 1;
      int after = Integer.parseInt(st.nextToken()) - 1;

      adj[before].add(after);
    }

    bw.write(solve() ? "Consistent" : "Inconsistent");

    br.close();
    bw.close();
  }

  private static boolean solve() {
    visited = new int[n];
    return !hasCycle();
  }

  private static boolean hasCycle() {
    for (int i = 0; i < n; i++) {
      if (visited[i] == VISITED) {
        continue;
      }

      if (visited[i] == VISITING) {
        return true;
      }

      if (hasCycle(i)) {
        return true;
      }
    }

    return false;
  }

  private static boolean hasCycle(int cur) {
    visited[cur] = VISITING;

    for (int next : adj[cur]) {
      if (visited[next] == VISITED) {
        continue;
      }

      if (visited[next] == VISITING) {
        return true;
      }

      if (hasCycle(next)) {
        return true;
      }
    }

    visited[cur] = VISITED;
    return false;
  }
}
