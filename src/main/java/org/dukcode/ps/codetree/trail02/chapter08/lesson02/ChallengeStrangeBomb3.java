package org.dukcode.ps.codetree.trail02.chapter08.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-strange-bomb-3/description">LINK</a>
 */
public class ChallengeStrangeBomb3 {

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
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      bombs[i] = Integer.parseInt(br.readLine());
      min = Math.min(min, bombs[i]);
      max = Math.max(max, bombs[i]);
    }

    bw.write(String.valueOf(solve(min, max)));
    br.close();
    bw.close();

  }

  private static int solve(int min, int max) {
    int maxCnt = 0;
    int ret = 0;
    for (int bomb = min; bomb <= max; bomb++) {
      int before = -1;
      int cnt = 0;
      boolean boomed = false;
      for (int idx = 0; idx < n; ++idx) {
        if (bombs[idx] != bomb) {
          continue;
        }

        if (before == -1) {
          before = idx;
          continue;
        }

        if (idx - before <= k) {
          cnt += boomed ? 1 : 2;
          boomed = true;
        } else {
          boomed = false;
        }

        before = idx;
      }

      if (cnt == 0) { // 0이면 패스하는게 중요
        continue;
      }

      if (maxCnt <= cnt) {
        maxCnt = cnt;
        ret = bomb;
      }
    }

    return ret;
  }
}
