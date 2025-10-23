package org.dukcode.ps.codetree.trail06.chapter01.lesson01;

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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-identifying-the-tree/description">LINK</a>
 */
public class ChallengeIdentifyingTheTree {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static List<Integer>[] adj;

  private static boolean[] vis;

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
    vis = new boolean[n];

    int sumLeafDepth = dfs(0, 0);

    return sumLeafDepth % 2;
  }


  private static int dfs(int cur, int d) {
    vis[cur] = true;

    int cntChildren = 0;
    int ret = 0;
    for (int next : adj[cur]) {
      if (vis[next]) {
        continue;
      }

      ret += dfs(next, d + 1);
      cntChildren++;
    }

    if (cntChildren == 0) {
      return d;
    }

    return ret;
  }
}
