package org.dukcode.ps.codetree.trail06.chapter01.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-adjacent-node-2/description">LINK</a>
 */
public class ChallengeAdjacentNode2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] values;
  private static List<Integer>[] adj;

  private static int[][] cache;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    values = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      values[i] = Integer.parseInt(st.nextToken());
    }

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

    bw.write(String.valueOf(solve()));
    bw.newLine();

    List<Integer> selectedNodes = findSelectedNodes();
    Collections.sort(selectedNodes);
    for (Integer idx : selectedNodes) {
      bw.write(String.valueOf(idx + 1));
      bw.write(' ');
    }

    br.close();
    bw.close();
  }

  private static List<Integer> findSelectedNodes() {
    List<Integer> selectedNodes = new ArrayList<>();
    boolean selected = dfs(0, -1, true) > dfs(0, -1, false);
    findSelectedNodes(0, -1, selected, selectedNodes);

    return selectedNodes;
  }

  private static void findSelectedNodes(int cur, int parent, boolean selected,
      List<Integer> selectedNodes) {
    if (selected) {
      selectedNodes.add(cur);
    }

    for (int next : adj[cur]) {
      if (next == parent) {
        continue;
      }

      if (selected) {
        findSelectedNodes(next, cur, false, selectedNodes);
      } else {
        boolean nextSelected = dfs(next, cur, true) > dfs(next, cur, false);
        findSelectedNodes(next, cur, nextSelected, selectedNodes);
      }
    }
  }

  private static int solve() {
    cache = new int[2][n];
    Arrays.fill(cache[0], -1);
    Arrays.fill(cache[1], -1);

    return Math.max(dfs(0, -1, true), dfs(0, -1, false));
  }

  private static int dfs(int cur, int parent, boolean selected) {
    if (cache[selected ? 1 : 0][cur] != -1) {
      return cache[selected ? 1 : 0][cur];
    }

    int ret = selected ? values[cur] : 0;
    for (int next : adj[cur]) {
      if (next == parent) {
        continue;
      }

      if (selected) {
        ret += dfs(next, cur, false);
      } else {
        ret += Math.max(dfs(next, cur, true), dfs(next, cur, false));
      }
    }

    return cache[selected ? 1 : 0][cur] = ret;

  }
}
