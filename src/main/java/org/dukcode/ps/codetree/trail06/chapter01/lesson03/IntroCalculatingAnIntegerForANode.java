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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-calculating-an-integer-for-a-node/description">LINK</a>
 */
public class IntroCalculatingAnIntegerForANode {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static List<Integer>[] children;
  private static int[] values;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    children = new List[n];
    for (int i = 0; i < n; i++) {
      children[i] = new ArrayList<>();
    }

    values = new int[n];

    for (int idx = 1; idx < n; idx++) {
      st = new StringTokenizer(br.readLine());
      int t = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      int p = Integer.parseInt(st.nextToken()) - 1;

      int val = t == 1 ? a : -a;

      values[idx] = val;
      children[p].add(idx);
    }

    bw.write(String.valueOf(dfs(0)));

    br.close();
    bw.close();
  }

  private static int dfs(int cur) {
    int ret = values[cur];
    for (int next : children[cur]) {
      int val = dfs(next);

      if (val > 0) {
        ret += val;
      }
    }

    return ret;
  }

}
