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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-adjacent-node/description">LINK</a>
 */
public class ChallengeAdjacentNode {

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

    cache = new int[2][n];
    Arrays.fill(cache[0], -1);
    Arrays.fill(cache[1], -1);

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
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
        ret += Math.max(dfs(next, cur, false), dfs(next, cur, true));
      }

    }

    return cache[selected ? 1 : 0][cur] = ret;
  }
}
