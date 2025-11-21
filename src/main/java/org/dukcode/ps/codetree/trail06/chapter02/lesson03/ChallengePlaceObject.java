package org.dukcode.ps.codetree.trail06.chapter02.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-place-object/description">LINK</a>
 */
public class ChallengePlaceObject {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[][] costs;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    costs = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      costs[0][i] = Integer.parseInt(br.readLine());
    }

    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= n; j++) {
        costs[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    bw.write(String.valueOf(solve()));

    bw.close();
    br.close();
  }

  private static int solve() {
    boolean[] visited = new boolean[n + 1];
    int[] dists = new int[n + 1];
    Arrays.fill(dists, Integer.MAX_VALUE);

    dists[0] = 0;

    int ret = 0;
    for (int i = 0; i <= n; i++) {

      // 선택
      int fr = -1;
      for (int idx = 0; idx <= n; idx++) {
        if (visited[idx]) {
          continue;
        }

        if (fr == -1 || dists[idx] < dists[fr]) {
          fr = idx;
        }
      }

      visited[fr] = true;
      ret += dists[fr];

      // 후보 갱신
      for (int to = 0; to <= n; to++) {
        dists[to] = Math.min(dists[to], costs[fr][to]);
      }
    }

    return ret;
  }
}
