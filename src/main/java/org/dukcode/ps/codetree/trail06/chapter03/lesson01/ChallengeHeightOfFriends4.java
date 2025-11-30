package org.dukcode.ps.codetree.trail06.chapter03.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-height-of-friends-4/description">LINK</a>
 */
public class ChallengeHeightOfFriends4 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static Edge[] edges;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    edges = new Edge[m];
    for (int idx = 0; idx < m; idx++) {
      st = new StringTokenizer(br.readLine());
      int fr = Integer.parseInt(st.nextToken()) - 1;
      int to = Integer.parseInt(st.nextToken()) - 1;

      edges[idx] = new Edge(fr, to);
    }

    int ans = solve();
    bw.write(ans == m ? "Consistent" : String.valueOf(ans + 1));

    br.close();
    bw.close();
  }

  private static int solve() {
    int frIn = 0;
    int toEx = m;

    while (frIn < toEx) {
      int mid = (frIn + toEx) / 2;

      if (!hasCycle(mid)) {
        frIn = mid + 1;
      } else {
        toEx = mid;
      }
    }

    return frIn;
  }

  private static boolean hasCycle(int toIn) {
    List<Integer>[] adj = new List[n];
    for (int i = 0; i < n; ++i) {
      adj[i] = new ArrayList<>();
    }

    int[] inDegrees = new int[n];
    for (int i = 0; i <= toIn; ++i) {
      int fr = edges[i].fr;
      int to = edges[i].to;

      adj[fr].add(to);
      inDegrees[to]++;
    }

    Queue<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < n; ++i) {
      if (inDegrees[i] == 0) {
        q.offer(i);
      }
    }

    boolean[] visited = new boolean[n];
    int visCount = 0;

    Loop:
    while (!q.isEmpty()) {

      int here = q.poll();
      visited[here] = true;
      visCount++;

      for (int there : adj[here]) {

        if (visited[there]) {
          break Loop;
        }

        inDegrees[there]--;

        if (inDegrees[there] != 0) {
          continue;
        }

        q.offer(there);
      }
    }

    return visCount != n;
  }

  private static class Edge {

    int fr;
    int to;

    public Edge(int fr, int to) {
      this.fr = fr;
      this.to = to;
    }
  }
}
