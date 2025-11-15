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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-determining-the-suitability-of-the-route-2/description">LINK</a>
 */
public class ChallengeDeterminingTheSuitabilityOfTheRoute2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int k;

  private static int[] route;

  private static int[] roots;
  private static int[] ranks;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    ranks = new int[n];
    roots = IntStream.range(0, n).toArray();

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;

      union(a, b);
    }

    route = new int[k];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < k; i++) {
      route[i] = Integer.parseInt(st.nextToken()) - 1;
    }

    bw.write(String.valueOf(isPossible(route) ? 1 : 0));

    br.close();
    bw.close();
  }

  private static boolean isPossible(int[] route) {
    int before = route[0];

    for (int i = 1; i < k; i++) {
      int now = route[i];

      if (!areInSameSet(before, now)) {
        return false;
      }

      before = now;
    }

    return true;
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

    if (ranks[rootA] < ranks[rootB]) {
      roots[rootA] = rootB;
      return;
    } else if (ranks[rootA] > ranks[rootB]) {
      roots[rootB] = rootA;
      return;
    }

    roots[rootA] = rootB;
    ranks[rootB]++;
  }

  private static int findRoot(int a) {
    if (a == roots[a]) {
      return a;
    }

    return roots[a] = findRoot(roots[a]);
  }
}
