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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-remove-cycle/description">LINK</a>
 */
public class ChallengeRemoveCycle {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m1; // 단방향
  private static int m2; // 양방향

  private static List<Integer>[] adj;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m1 = Integer.parseInt(st.nextToken());
    m2 = Integer.parseInt(st.nextToken());

    adj = new List[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new ArrayList<>();
    }

    for (int i = 0; i < m1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;

      adj[a].add(b);
    }

    for (int i = 0; i < m2; i++) {
      st = new StringTokenizer(br.readLine());
      // skip
    }

    bw.write(solve());

    br.close();
    bw.close();
  }

  private static String solve() {
    return hasCycle() ? "No" : "Yes";
  }

  private static boolean hasCycle() {
    int[] visited = new int[n];
    for (int i = 0; i < n; i++) {
      if (visited[i] == 2) {
        continue;
      }

      if (visited[i] == 1) {
        return true;
      }

      if (hasCycle(i, visited)) {
        return true;
      }
    }

    return false;
  }

  private static boolean hasCycle(int cur, int[] visited) {
    visited[cur] = 1;

    for (int next : adj[cur]) {
      if (visited[next] == 2) {
        continue;
      }

      if (visited[next] == 1) {
        return true;
      }

      if (hasCycle(next, visited)) {
        return true;
      }

    }
    visited[cur] = 2;
    return false;
  }
}
