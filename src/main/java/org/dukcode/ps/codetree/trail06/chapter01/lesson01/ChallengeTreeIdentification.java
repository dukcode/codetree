package org.dukcode.ps.codetree.trail06.chapter01.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-tree-identification/description">LINK</a>
 */
public class ChallengeTreeIdentification {

  private static final int MX_V = 10_000;

  private static final int UNVISITED = 0;
  private static final int VISITING = 1;
  private static final int VISITED = 2;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int m;
  private static List<Integer>[] adj;

  private static Map<Integer, Integer> inbound;

  private static int[] visited;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    m = Integer.parseInt(br.readLine());

    adj = new List[MX_V + 1];
    for (int i = 1; i <= MX_V; i++) {
      adj[i] = new ArrayList<>();
    }

    inbound = new HashMap<>();

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int fr = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      adj[fr].add(to);

      inbound.put(fr, inbound.getOrDefault(fr, 0));
      inbound.put(to, inbound.getOrDefault(to, 0) + 1);
    }

    bw.write(String.valueOf(isTree() ? 1 : 0));

    br.close();
    bw.close();
  }

  private static boolean isTree() {
    int rootCnt = 0;
    for (int cnt : inbound.values()) {
      if (cnt == 0) {
        rootCnt++;
        continue;
      }

      if (cnt != 1) {
        return false;
      }
    }

    if (rootCnt != 1) {
      return false;
    }

    return !hasCycle();
  }

  private static boolean hasCycle() {
    visited = new int[MX_V + 1];

    for (int v = 1; v <= MX_V; v++) {
      if (visited[v] != UNVISITED) {
        continue;
      }

      if (hasCycle(v)) {
        return true;
      }
    }
    return false;
  }

  private static boolean hasCycle(int v) {
    visited[v] = VISITING;

    for (int neighbor : adj[v]) {
      if (visited[neighbor] == VISITED) {
        continue;
      }

      if (visited[neighbor] == VISITING) {
        return true;
      }

      if (hasCycle(neighbor)) {
        return true;
      }
    }

    visited[v] = VISITED;

    return false;
  }
}
