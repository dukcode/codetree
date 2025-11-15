package org.dukcode.ps.codetree.trail06.chapter02.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-do-not-connect-with-a-specific-node/description">LINK</a>
 */
public class ChallengeDoNotConnectWithASpecificNode {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  private static int a;
  private static int b;
  private static int k;

  private static int[] ranks;
  private static int[] roots;
  private static int[] sizes;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    ranks = new int[n];
    roots = IntStream.range(0, n).toArray();
    sizes = new int[n];
    Arrays.fill(sizes, 1);

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;

      union(a, b);
    }

    st = new StringTokenizer(br.readLine());
    a = Integer.parseInt(st.nextToken()) - 1;
    b = Integer.parseInt(st.nextToken()) - 1;
    k = Integer.parseInt(st.nextToken());

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    Set<Integer> connects = new HashSet<>();
    for (int idx = 0; idx < n; ++idx) {
      if (areInSameSet(a, idx) || areInSameSet(b, idx)) {
        continue;
      }

      connects.add(findRoot(idx));
    }

    List<Integer> sizesToConnect = connects.stream()
        .map(idx -> sizes[idx])
        .collect(Collectors.toCollection(ArrayList::new));

    sizesToConnect.sort(Collections.reverseOrder());

    int ret = 0;
    for (int i = 0; i < Math.min(k, sizesToConnect.size()); ++i) {
      ret += sizesToConnect.get(i);
    }

    return ret + sizes[findRoot(a)];
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
      sizes[rootB] += sizes[rootA];
      return;
    } else if (ranks[rootA] > ranks[rootB]) {
      roots[rootB] = rootA;
      sizes[rootA] += sizes[rootB];
      return;
    }

    roots[rootA] = rootB;
    ranks[rootB]++;
    sizes[rootB] += sizes[rootA];
  }

  private static int findRoot(int x) {
    if (roots[x] == x) {
      return x;
    }

    return roots[x] = findRoot(roots[x]);
  }
}
