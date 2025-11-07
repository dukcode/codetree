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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-node-best-count/description">LINK</a>
 */
public class IntroNodeBestCount {

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

    cache = new int[2][n];
    Arrays.fill(cache[0], -1);
    Arrays.fill(cache[1], -1);

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    return Math.min(dfs(0, true, -1), dfs(0, false, -1));
  }

  private static int dfs(int cur, boolean colored, int before) {

    if (cache[colored ? 1 : 0][cur] != -1) {
      return cache[colored ? 1 : 0][cur];
    }

    int ret = colored ? 1 : 0;
    for (int next : adj[cur]) {
      if (next == before) {
        continue;
      }

      if (colored) {
        // visited 배열 사용하면 여기서 오염됨..
        ret += Math.min(dfs(next, false, cur), dfs(next, true, cur));
      } else {
        ret += dfs(next, true, cur);
      }
    }

    return cache[colored ? 1 : 0][cur] = ret;
  }
}
