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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-coloring-not-adjacently-2/description">LINK</a>
 */
public class ChallengeColoringNotAdjacently2 {

  private static final int MN = -987_654_321;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static List<Integer>[] adj;
  private static int[] values;
  private static int k;

  private static int[][][] cache;

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

    values = new int[n];
    for (int i = 0; i < n; i++) {
      values[i] = Integer.parseInt(br.readLine());
    }

    k = Integer.parseInt(br.readLine());

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    cache = new int[n][2][k + 1];
    for (int idx = 0; idx < n; ++idx) {
      for (int selected = 0; selected <= 1; selected++) {
        Arrays.fill(cache[idx][selected], -1);
      }
    }

    return Math.max(dfs(0, -1, 0, k), dfs(0, -1, 1, k));
  }

  private static int dfs(int cur, int parent, int selected, int remain) {

    if (cache[cur][selected][remain] != -1) {
      return cache[cur][selected][remain];
    }

    int toAdd = selected == 1 ? values[cur] : 0;
    int remainNext = remain - (selected == 1 ? 1 : 0);

    // 불가능 조건
    if (remainNext < 0) {
      return MN;
    }

    int left = -1;
    int right = -1;
    for (int next : adj[cur]) {
      if (next == parent) {
        continue;
      }

      if (left == -1) {
        left = next;
      } else {
        right = next;
      }
    }

    if (left == -1) {
      return toAdd;
    }

    int ret = 0;
    for (int leftRemain = 0; leftRemain <= remainNext; leftRemain++) {
      int rightRemain = remainNext - leftRemain;

      if (selected == 1) {
        ret = Math.max(ret,
            dfs(left, cur, 0, leftRemain) + dfs(right, cur, 0, rightRemain) + toAdd);
      } else {
        ret = Math.max(ret,
            dfs(left, cur, 0, leftRemain) + dfs(right, cur, 0, rightRemain) + toAdd);
        ret = Math.max(ret,
            dfs(left, cur, 1, leftRemain) + dfs(right, cur, 0, rightRemain) + toAdd);
        ret = Math.max(ret,
            dfs(left, cur, 0, leftRemain) + dfs(right, cur, 1, rightRemain) + toAdd);
        ret = Math.max(ret,
            dfs(left, cur, 1, leftRemain) + dfs(right, cur, 1, rightRemain) + toAdd);
      }
    }

    return cache[cur][selected][remain] = ret;
  }
}
