package org.dukcode.ps.codetree.trail04.chapter06.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-collect-crystals/description">LINK</a>
 */
public class ChallengeCollectCrystals {

  private static final int L = 0;
  private static final int R = 1;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int k;
  private static int[] pos;

  private static int[][][] cache;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    pos = new int[n];

    char[] line = br.readLine().toCharArray();
    for (int i = 0; i < n; i++) {
      pos[i] = line[i] == 'L' ? L : R;
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    cache = new int[n][2][k + 1];
    for (int i = 0; i < n; i++) {
      for (int p = 0; p < 2; p++) {
        Arrays.fill(cache[i][p], -1);
      }
    }

    return solve(0, L, k);
  }

  private static int solve(int idx, int now, int k) {
    if (idx == n) {
      return 0;
    }

    if (cache[idx][now][k] != -1) {
      return cache[idx][now][k];
    }

    int ret = (now == pos[idx] ? 1 : 0) + solve(idx + 1, now, k);

    if (k > 0) {
      ret = Math.max(ret, (now != pos[idx] ? 1 : 0) + solve(idx + 1, (now + 1) % 2, k - 1));
    }

    return cache[idx][now][k] = ret;
  }
}
