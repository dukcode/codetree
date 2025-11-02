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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-touring-the-line/description">LINK</a>
 */
public class ChallengeTouringTheLine {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int d;
  private static List<Node>[] adj;

  private static boolean[] vis;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());

    adj = new List[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new ArrayList<>();
    }

    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;
      int dist = Integer.parseInt(st.nextToken());

      adj[a].add(new Node(b, dist));
      adj[b].add(new Node(a, dist));
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    PathInfo a = getFartestNode(0);
    PathInfo b = getFartestNode(a.idx);
    return (b.dist + d - 1) / d;
  }

  private static PathInfo getFartestNode(int fromIdx) {
    vis = new boolean[n];
    return getFartestNode(fromIdx, 0, 0);
  }

  private static PathInfo getFartestNode(int cur, int curCnt, int curDist) {
    vis[cur] = true;

    int retIdx = cur;
    int retCnt = curCnt;
    int retDist = curDist;
    for (Node next : adj[cur]) {
      if (vis[next.idx]) {
        continue;
      }

      PathInfo pathInfo = getFartestNode(next.idx, curCnt + 1, curDist + next.dist);

      if (pathInfo.cnt > retCnt || (pathInfo.cnt == retCnt && pathInfo.dist < retDist)) {
        retIdx = pathInfo.idx;
        retCnt = pathInfo.cnt;
        retDist = pathInfo.dist;
      }
    }

    return new PathInfo(retIdx, retCnt, retDist);
  }

  private static class PathInfo {

    int idx;
    int cnt;
    int dist;

    public PathInfo(int idx, int cnt, int dist) {
      this.idx = idx;
      this.cnt = cnt;
      this.dist = dist;
    }
  }

  private static class Node {

    int idx;
    int dist;

    public Node(int idx, int dist) {
      this.idx = idx;
      this.dist = dist;
    }
  }
}
