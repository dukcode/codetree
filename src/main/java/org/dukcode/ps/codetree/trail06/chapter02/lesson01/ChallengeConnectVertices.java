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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-connect-vertices/description">LINK</a>
 */
public class ChallengeConnectVertices {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;

  private static int[] roots;
  private static int[] ranks;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    roots = IntStream.range(0, n).toArray();
    ranks = new int[n];

    for (int i = 0; i < n - 2; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;

      union(a, b);
    }

    int[] rep = new int[n];
    Arrays.fill(rep, -1);
    for (int idx = 0; idx < n; idx++) {
      int root = findRoot(idx);

      if (rep[root] == -1) {
        rep[root] = idx;
      }
    }

    int first = -1;
    int second = -1;
    for (int i = 0; i < n; i++) {
      if (rep[i] == -1) {
        continue;
      }

      if (first == -1) {
        first = rep[i];
      } else {
        second = rep[i];
        break;
      }
    }

    bw.write(String.valueOf(Math.min(first, second) + 1));
    bw.write(' ');
    bw.write(String.valueOf(Math.max(first, second) + 1));

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
      return;
    } else if (ranks[rootA] > ranks[rootB]) {
      roots[rootB] = rootA;
      return;
    }

    roots[rootB] = rootA;
    ranks[rootA]++;
  }

  private static int findRoot(int a) {
    if (roots[a] == a) {
      return a;
    }

    return roots[a] = findRoot(roots[a]);
  }
}
