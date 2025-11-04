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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-diameter-of-tree-3/description">LINK</a>
 */
public class ChallengeDiameterOfTree3 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static List<Edge>[] adj;

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
      int dist = Integer.parseInt(st.nextToken());

      adj[a].add(new Edge(b, dist));
      adj[b].add(new Edge(a, dist));
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    Path a = findFartestPath(0, 0, -1, new boolean[n]);
    Path b = findFartestPath(a.targetIdx, 0, -1, new boolean[n]);

    Path c = findFartestPath(b.targetIdx, 0, a.targetIdx, new boolean[n]);
    Path d = findFartestPath(a.targetIdx, 0, b.targetIdx, new boolean[n]);
    return Math.max(c.dist, d.dist);
  }

  private static Path findFartestPath(int hereIdx, int dist, int avoidIdx, boolean[] visited) {
    visited[hereIdx] = true;

    int retDist = dist;
    int retIdx = hereIdx;
    for (Edge next : adj[hereIdx]) {
      int nextIdx = next.toIdx;

      if (visited[nextIdx]) {
        continue;
      }

      if (nextIdx == avoidIdx) {
        continue;
      }

      Path nextPath = findFartestPath(nextIdx, dist + next.dist, avoidIdx, visited);

      if (nextPath.dist > retDist) {
        retDist = nextPath.dist;
        retIdx = nextPath.targetIdx;
      }

    }

    return new Path(retIdx, retDist);
  }

  private static class Path {

    int targetIdx;
    int dist;

    public Path(int targetIdx, int dist) {
      this.targetIdx = targetIdx;
      this.dist = dist;
    }
  }

  private static class Edge {

    int toIdx;
    int dist;

    public Edge(int toIdx, int dist) {
      this.toIdx = toIdx;
      this.dist = dist;
    }
  }
}
