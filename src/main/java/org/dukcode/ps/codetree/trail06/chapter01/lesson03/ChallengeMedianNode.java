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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-median-node/description">LINK</a>
 */
public class ChallengeMedianNode {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int r;
  private static List<Integer>[] adj;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken()) - 1;

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
    int medianIdx = findMedian(r, -1);
    return maxSubtreeCntDiff(medianIdx);
  }

  private static int maxSubtreeCntDiff(int root) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int next : adj[root]) {
      int cnt = cntSubtreeCnt(next, root);
      max = Math.max(max, cnt);
      min = Math.min(min, cnt);
    }

    return max - min;
  }

  private static int cntSubtreeCnt(int cur, int parent) {
    int ret = 1;
    for (int next : adj[cur]) {
      if (next == parent) {
        continue;
      }

      ret += cntSubtreeCnt(next, cur);
    }

    return ret;
  }

  private static int findMedian(int cur, int parent) {
    if (cur == r && adj[cur].size() >= 2) {
      return cur;
    }

    if (cur != r && adj[cur].size() >= 3) {
      return cur;
    }

    for (int next : adj[cur]) {
      if (next == parent) {
        continue;
      }

      return findMedian(next, cur);
    }

    return cur;
  }

}
