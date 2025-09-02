package org.dukcode.ps.codetree.trail04.chapter06.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-explore-temple/description">LINK</a>
 */
public class ChallengeExploreTemple2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[][] score;

  private static int[][][] cache;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    score = new int[n][3];
    for (int idx = 0; idx < n; idx++) {
      st = new StringTokenizer(br.readLine());
      for (int dir = 0; dir < 3; dir++) {
        score[idx][dir] = Integer.parseInt(st.nextToken());
      }
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    cache = new int[n][3][3];
    int ret = 0;
    for (int dir = 0; dir < 3; ++dir) {
      ret = Math.max(ret, solve(0, dir, dir));
    }

    return ret;
  }

  private static int solve(int idx, int dir, int firstDir) {
    if (idx == n - 1) {
      return dir == firstDir ? 0 : score[n - 1][dir];
    }

    if (cache[idx][dir][firstDir] != 0) {
      return cache[idx][dir][firstDir];
    }

    int ret = 0;
    for (int nextDir = 0; nextDir < 3; ++nextDir) {
      if (dir == nextDir) {
        continue;
      }

      ret = Math.max(ret, solve(idx + 1, nextDir, firstDir) + score[idx][dir]);
    }
    return cache[idx][dir][firstDir] = ret;
  }

}
