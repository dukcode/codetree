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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-tree-optimal-node/description">LINK</a>
 */
public class ChallengeTreeOptimalNode {

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
    Node a = findFartestNode(0, 0, vis);

    vis = new boolean[n];
    Node b = findFartestNode(a.idx, 0, vis);

    return (b.d + 1) / 2;
  }

  private static Node findFartestNode(int cur, int dist, boolean[] vis) {
    vis[cur] = true;

    int idx = cur;
    int d = dist;
    for (int next : adj[cur]) {
      if (vis[next]) {
        continue;
      }

      Node fromCur = findFartestNode(next, dist + 1, vis);
      if (fromCur.d > d) {
        idx = fromCur.idx;
        d = fromCur.d;
      }
    }

    return new Node(idx, d);
  }

  private static class Node {

    int idx;
    int d;

    public Node(int idx, int d) {
      this.idx = idx;
      this.d = d;
    }

  }
}
