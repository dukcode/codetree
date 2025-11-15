package org.dukcode.ps.codetree.trail06.chapter02.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-connect-with-the-most-vertices/description">LINK</a>
 */
public class ChallengeConnectWithTheMostVertices {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int k;

  private static int[] minCosts;

  private static int[] roots;
  private static int[] ranks;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    minCosts = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      minCosts[i] = Integer.parseInt(st.nextToken());
    }

    roots = IntStream.range(0, n).toArray();
    ranks = new int[n];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;

      union(a, b);

      int root = findRoot(a);
    }

    int sumCost = solve();

    bw.write(sumCost < 0 ? "NO" : String.valueOf(sumCost));

    br.close();
    bw.close();
  }

  private static int solve() {
    List<Integer> costsToAdd = new ArrayList<>();
    boolean[] visited = new boolean[n];
    for (int idx = 0; idx < n; idx++) {
      if (visited[findRoot(idx)]) {
        continue;
      }

      costsToAdd.add(minCosts[findRoot(idx)]);
      visited[findRoot(idx)] = true;
    }

    costsToAdd.sort(Comparator.naturalOrder());

    int ret = 0;
    for (int i = 1; i < costsToAdd.size(); i++) {
      ret += costsToAdd.get(0) + costsToAdd.get(i);
    }
    return ret > k ? -1 : ret;
  }

  private static void union(int a, int b) {
    int rootA = findRoot(a);
    int rootB = findRoot(b);

    if (rootA == rootB) {
      return;
    }

    int minCost = Math.min(minCosts[rootA], minCosts[rootB]);

    if (ranks[rootA] < ranks[rootB]) {
      roots[rootA] = rootB;
      minCosts[rootB] = minCost;
      return;
    } else if (ranks[rootA] > ranks[rootB]) {
      roots[rootB] = rootA;
      minCosts[rootA] = minCost;
      return;
    }

    roots[rootA] = rootB;
    minCosts[rootB] = minCost;
    ranks[rootB]++;
  }

  private static int findRoot(int x) {
    if (roots[x] == x) {
      return x;
    }

    return roots[x] = findRoot(roots[x]);
  }
}
