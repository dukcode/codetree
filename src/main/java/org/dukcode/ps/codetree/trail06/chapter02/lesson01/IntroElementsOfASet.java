package org.dukcode.ps.codetree.trail06.chapter02.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-elements-of-a-set/description">LINK</a>
 */
public class IntroElementsOfASet {

  private static final int UNION = 0;
  private static final int IN_SAME_SET = 1;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  private static int[] parents;
  private static int[] ranks;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    parents = IntStream.range(0, n).toArray();
    ranks = new int[n];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int command = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;

      switch (command) {
        case UNION:
          union(a, b);
          break;
        case IN_SAME_SET:
          bw.write(String.valueOf(areInSameSet(a, b) ? 1 : 0));
          bw.newLine();
          break;
        default:
          break;
      }
    }

    br.close();
    bw.close();
  }

  private static boolean areInSameSet(int a, int b) {
    return findRoot(a) == findRoot(b);
  }

  private static void union(int a, int b) {
    int rootA = findRoot(a);
    int rootB = findRoot(b);

    if (rootA == rootB) {
      return;
    }

    if (ranks[rootA] > ranks[rootB]) {
      parents[rootB] = rootA;
      return;
    } else if (ranks[rootA] < ranks[rootB]) {
      parents[rootA] = rootB;
      return;
    }

    parents[rootB] = rootA;
    ranks[rootA]++;
  }

  private static int findRoot(int a) {
    if (a == parents[a]) {
      return a;
    }

    return parents[a] = findRoot(parents[a]);
  }
}
