package org.dukcode.ps.codetree.trail02.chapter07.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-strange-bomb-2/description">LINK</a>
 */
public class ChallengeStrangeBomb2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int k;

  private static int[] bombs;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    bombs = new int[n];
    for (int i = 0; i < n; i++) {
      bombs[i] = Integer.parseInt(br.readLine());
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();

  }

  private static int solve() {
    int maxBomb = Integer.MIN_VALUE;
    for (int x = 0; x < n; x++) {
      if (exploded(x)) {
        maxBomb = Math.max(maxBomb, bombs[x]);
      }
    }
    return maxBomb == Integer.MIN_VALUE ? -1 : maxBomb;
  }

  private static boolean exploded(int x) {
    for (int dx = -k; dx <= k; ++dx) {
      if (dx == 0) {
        continue;
      }

      int nx = x + dx;

      if (nx < 0 || nx >= n) {
        continue;
      }

      if (bombs[nx] == bombs[x]) {
        return true;
      }
    }

    return false;
  }
}
