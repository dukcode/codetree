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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-node-traversal/description">LINK</a>
 */
public class ChallengeNodeTraversal {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int s;
  private static int d;

  private static List<Integer>[] adj;

  private static int[] dist;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    s = Integer.parseInt(st.nextToken()) - 1;
    d = Integer.parseInt(st.nextToken());

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
    dist = new int[n];
    dist(s, -1);

    return calcDist();
  }

  private static int calcDist() {
    int cnt = 0;
    for (int i = 0; i < n; ++i) {
      if (i == s) {
        continue;
      }

      if (dist[i] >= d) {
        cnt++;
      }
    }

    return 2 * cnt;
  }

  private static int dist(int cur, int parent) {

    int ret = 0;
    for (int next : adj[cur]) {
      if (next == parent) {
        continue;
      }
      ret = Math.max(ret, dist(next, cur) + 1);
    }

    return dist[cur] = ret;
  }
}
