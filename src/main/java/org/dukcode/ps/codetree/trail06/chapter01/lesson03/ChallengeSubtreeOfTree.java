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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-subtree-of-tree/description">LINK</a>
 */
public class ChallengeSubtreeOfTree {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int r;
  private static int q;

  private static List<Integer>[] adj;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken()) - 1;
    q = Integer.parseInt(st.nextToken());

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

    int[] cntSubtree = cntSubtree(r);

    for (int i = 0; i < q; i++) {
      int root = Integer.parseInt(br.readLine()) - 1;
      bw.write(String.valueOf(cntSubtree[root]));
      bw.newLine();
    }

    br.close();
    bw.close();
  }

  private static int[] cntSubtree(int root) {
    int[] cnt = new int[n];
    cntSubtree(root, -1, cnt);
    return cnt;
  }

  private static int cntSubtree(int cur, int parent, int[] cnt) {
    if (cnt[cur] != 0) {
      return cnt[cur];
    }

    int ret = 1;
    for (int next : adj[cur]) {
      if (next == parent) {
        continue;
      }

      ret += cntSubtree(next, cur, cnt);

    }

    return cnt[cur] = ret;
  }
}
