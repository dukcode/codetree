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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-connected-vertex/description">LINK</a>
 */
public class ChallengeConnectedVertex {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  private static int[] roots;
  private static int[] ranks;
  private static int[] sizes;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    roots = IntStream.range(0, n).toArray();
    ranks = new int[n];

    sizes = new int[n];
    Arrays.fill(sizes, 1);

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      String command = st.nextToken();
      switch (command) {
        case "x": {
          int a = Integer.parseInt(st.nextToken()) - 1;
          int b = Integer.parseInt(st.nextToken()) - 1;
          union(a, b);
          break;
        }
        case "y": {
          int a = Integer.parseInt(st.nextToken()) - 1;
          bw.write(String.valueOf(sizes[findRoot(a)]));
          bw.newLine();
          break;
        }
        default:
          break;
      }
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

    roots[rootA] = rootB;
    sizes[rootB] += sizes[rootA];
    ranks[rootB]++;

  }

  private static int findRoot(int a) {
    if (roots[a] == a) {
      return a;
    }

    return roots[a] = findRoot(roots[a]);
  }
}
