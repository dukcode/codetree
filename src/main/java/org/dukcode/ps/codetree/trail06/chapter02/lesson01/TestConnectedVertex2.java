package org.dukcode.ps.codetree.trail06.chapter02.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-connected-vertex-2/description">LINK</a>
 */
public class TestConnectedVertex2 {

  private static int MX = 100_000;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;

  private static int[] roots;
  private static int[] ranks;
  private static int[] sizes;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    roots = IntStream.range(0, MX).toArray();

    ranks = new int[MX];

    sizes = new int[MX];
    Arrays.fill(sizes, 1);

    n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;

      union(a, b);
      bw.write(String.valueOf(sizes[findRoot(a)]));
      bw.newLine();
    }

    br.close();
    bw.close();
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

    roots[rootB] = rootA;
    sizes[rootA] += sizes[rootB];
    ranks[rootA]++;
  }

  private static int findRoot(int x) {
    return roots[x] == x ? x : (roots[x] = findRoot(roots[x]));
  }
}
