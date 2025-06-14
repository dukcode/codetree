package org.dukcode.ps.codetree.trail02.chapter07.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-developers-rank/description">LINK</a>
 */
public class ChallengeDevelopersRank {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int k;
  private static int n;

  private static int[][] ranks;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    k = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());

    ranks = new int[k][n];
    for (int game = 0; game < k; ++game) {
      st = new StringTokenizer(br.readLine());
      for (int order = 0; order < n; ++order) {
        int idx = Integer.parseInt(st.nextToken()) - 1;
        ranks[game][idx] = order;
      }
    }

    int ans = 0;
    for (int winner = 0; winner < n; ++winner) {
      for (int loser = 0; loser < n; loser++) {
        if (alwaysWin(winner, loser)) {
          ans++;
        }
      }
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

  private static boolean alwaysWin(int winner, int loser) {
    for (int game = 0; game < k; ++game) {
      if (ranks[game][winner] >= ranks[game][loser]) {
        return false;
      }
    }

    return true;
  }
}
