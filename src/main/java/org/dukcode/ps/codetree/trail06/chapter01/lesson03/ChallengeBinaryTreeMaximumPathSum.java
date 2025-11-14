package org.dukcode.ps.codetree.trail06.chapter01.lesson03;

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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-binary-tree-maximum-path-sum/description">LINK</a>
 */
public class ChallengeBinaryTreeMaximumPathSum {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static List<Integer>[] adj;
  private static int[] values;

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
    for (int i = 0; i < n; ++i) {
      values[i] = Integer.parseInt(br.readLine());
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    return dfs(0, -1).globalMax;
  }

  private static NodeResult dfs(int cur, int parent) {

    int maxSumSingle = values[cur];
    int maxSumVPath = values[cur];
    int globalMax = Integer.MIN_VALUE;

    for (int next : adj[cur]) {
      if (next == parent) {
        continue;
      }

      NodeResult childResult = dfs(next, cur);

      maxSumSingle = Math.max(maxSumSingle, childResult.maxSumFrom + values[cur]);

      maxSumVPath += Math.max(0, childResult.maxSumFrom);

      globalMax = Math.max(globalMax, childResult.globalMax);
    }

    globalMax = Math.max(globalMax, maxSumVPath);

    return new NodeResult(maxSumSingle, globalMax);
  }

  private static class NodeResult {

    int maxSumFrom;
    int globalMax;

    public NodeResult(int maxSumFrom, int globalMax) {
      this.maxSumFrom = maxSumFrom;
      this.globalMax = globalMax;
    }
  }

}
