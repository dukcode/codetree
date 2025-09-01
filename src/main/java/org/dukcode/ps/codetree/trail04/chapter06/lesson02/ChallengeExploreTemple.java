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
public class ChallengeExploreTemple {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[][] score;
  private static int[] m;
  private static int[] r;

  private static int[][] cache;

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
    cache = new int[n][3];
    int ret = 0;
    for (int dir = 0; dir < 3; ++dir) {
      ret = Math.max(ret, solve(0, dir));
    }

    return ret;
  }

  private static int solve(int idx, int dir) {
    if (idx == n) {
      return 0;
    }

    if (cache[idx][dir] != 0) {
      return cache[idx][dir];
    }

    int ret = 0;
    for (int nextDir = 0; nextDir < 3; ++nextDir) {
      if (dir == nextDir) {
        continue;
      }

      ret = Math.max(ret, solve(idx + 1, nextDir) + score[idx][dir]);
    }
    return cache[idx][dir] = ret;
  }

}
