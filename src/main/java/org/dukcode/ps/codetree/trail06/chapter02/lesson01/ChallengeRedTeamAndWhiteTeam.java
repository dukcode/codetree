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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-red-team-and-white-team/description">LINK</a>
 */
public class ChallengeRedTeamAndWhiteTeam {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  private static int[] roots;
  private static int[] ranks;
  private static int[] againsts;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    roots = IntStream.range(0, n).toArray();
    ranks = new int[n];
    againsts = new int[n];
    Arrays.fill(againsts, -1);

    boolean isParadox = false;
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;

      if (!beta(a, b)) {
        isParadox = true;
        break;
      }
    }

    bw.write(String.valueOf(isParadox ? 0 : 1));

    br.close();
    bw.close();
  }

  private static boolean beta(int a, int b) {
    int rootA = findRoot(a);
    int rootB = findRoot(b);

    if (rootA == rootB) {
      return false;
    }

    if (againsts[rootA] != -1) {
      union(againsts[rootA], rootB);
    }

    if (againsts[rootB] != -1) {
      union(againsts[rootB], rootA);
    }

    rootA = findRoot(a);
    rootB = findRoot(b);

    againsts[rootA] = rootB;
    againsts[rootB] = rootA;

    return true;
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

  private static int findRoot(int x) {
    if (roots[x] == x) {
      return x;
    }

    return roots[x] = findRoot(roots[x]);
  }
}
