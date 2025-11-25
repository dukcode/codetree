package org.dukcode.ps.codetree.trail06.chapter03.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-detect-cycle/description">LINK</a>
 */
public class ChallengeDetectCycle {

  private static final int VISITING = 1;
  private static final int VISITED = 2;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static List<Integer>[] adj;
  private static int[] inbounds;

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

    inbounds = new int[n];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int fr = Integer.parseInt(st.nextToken()) - 1;
      int to = Integer.parseInt(st.nextToken()) - 1;

      adj[fr].add(to);
      inbounds[to]++;
    }

    bw.write(solve());

    br.close();
    bw.close();
  }

  private static String solve() {
    return hasCycle3() ? "Exists" : "Not Exists";
  }

  private static boolean hasCycle3() {
    boolean[] visited = new boolean[n];
    int visCnt = 0;

    Queue<Integer> q = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      if (inbounds[i] == 0) {
        q.offer(i);
        visited[i] = true;
      }
    }

    while (!q.isEmpty()) {
      int cur = q.poll();
      visCnt++;

      for (int next : adj[cur]) {
        if (visited[next]) {
          continue;
        }

        inbounds[next]--;

        if (inbounds[next] == 0) {
          visited[next] = true;
          q.offer(next);
        }
      }
    }

    return visCnt != n;
  }

  private static boolean hasCycle2() {
    List<Integer> order = new ArrayList<>();
    boolean[] visited = new boolean[n];
    for (int idx = 0; idx < n; idx++) {
      if (visited[idx]) {
        continue;
      }

      dfs(idx, visited, order);
    }

    Collections.reverse(order);

    int[] pos = new int[n];
    for (int idx = 0; idx < n; idx++) {
      pos[order.get(idx)] = idx;
    }

    for (int fr = 0; fr < n; fr++) {
      for (int to : adj[fr]) {
        if (pos[fr] > pos[to]) {
          return true;
        }
      }
    }

    return false;
  }

  private static void dfs(int cur, boolean[] visited, List<Integer> order) {
    visited[cur] = true;

    for (int next : adj[cur]) {
      if (visited[next]) {
        continue;
      }

      dfs(next, visited, order);
    }

    order.add(cur);
  }

  private static boolean hasCycle() {
    int[] visited = new int[n];
    for (int i = 0; i < n; i++) {
      if (visited[i] == VISITED) {
        continue;
      }

      if (visited[i] == VISITING) {
        return true;
      }

      if (hasCycle(i, visited)) {
        return true;
      }
    }

    return false;
  }

  private static boolean hasCycle(int cur, int[] visited) {
    visited[cur] = VISITING;

    for (int next : adj[cur]) {
      if (visited[next] == VISITED) {
        continue;
      }

      if (visited[next] == VISITING) {
        return true;
      }

      if (hasCycle(next, visited)) {
        return true;
      }
    }

    visited[cur] = VISITED;

    return false;
  }

}
