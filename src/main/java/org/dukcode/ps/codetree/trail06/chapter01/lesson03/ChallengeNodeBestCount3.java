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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-node-best-count-3/description">LINK</a>
 */
public class ChallengeNodeBestCount3 {

  private static final int MX = 987_654_321;

  private static final int ME = 0; // 나 O
  private static final int PARENT = 1; // 부모 O, 나 X
  private static final int CHILD = 2; // 부모 X, 나 X

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static List<Integer>[] adj;

  private static int[][] cache;

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

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    cache = new int[3][n];
    Arrays.fill(cache[0], -1);
    Arrays.fill(cache[1], -1);
    Arrays.fill(cache[2], -1);

    return Math.min(dfs(0, -1, 0), dfs(0, 1, 2));
  }

  private static int dfs(int cur, int parent, int state) {
    if (cache[state][cur] != -1) {
      return cache[state][cur];
    }

    if (state == ME) {
      int ret = 1;
      for (int next : adj[cur]) {
        if (next == parent) {
          continue;
        }

        ret += Math.min(dfs(next, cur, PARENT), dfs(next, cur, ME));
      }

      return cache[state][cur] = ret;
    }

    if (state == PARENT) {
      int ret = 0;
      for (int next : adj[cur]) {
        if (next == parent) {
          continue;
        }

        ret += Math.min(dfs(next, cur, ME), dfs(next, cur, CHILD));
      }

      return cache[state][cur] = ret;
    }

    // state == CHILD
    int ret = 0;
    int cntChild = 0;
    boolean isCovered = false;
    int minDiff = Integer.MAX_VALUE;
    for (int next : adj[cur]) {
      if (next == parent) {
        continue;
      }

      cntChild++;

      int nextMe = dfs(next, cur, ME);
      int nextChild = dfs(next, cur, CHILD);

      if (nextMe <= nextChild) {
        ret += nextMe;
        isCovered = true;
      } else {
        ret += nextChild;
        minDiff = Math.min(minDiff, nextMe - nextChild);
      }
    }

    if (cntChild == 0) {
      return cache[state][cur] = MX;
    }

    if (isCovered) {
      return cache[state][cur] = ret;
    }

    return cache[state][cur] = ret + minDiff;
  }
}
