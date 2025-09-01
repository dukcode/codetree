package org.dukcode.ps.codetree.trail04.chapter05.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-gain-exp-quickly/description">LINK</a>
 */
public class ChallengeGainExpQuickly {

  private static final int MX = 987_654_321;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n; // ~100
  private static int m; // ~1_000_000
  private static int[] e; //  ~1_000_000
  private static int[] t; // ~100
  private static int totalTime;

  private static int[][] cache; // idx부터 진행했을 때 t시간으로 최대 얻을 수 있는 경험치

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    e = new int[n];
    t = new int[n];
    totalTime = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      e[i] = Integer.parseInt(st.nextToken());
      t[i] = Integer.parseInt(st.nextToken());
      totalTime += t[i];
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    cache = new int[n][totalTime + 1];
    for (int i = 0; i < n; i++) {
      Arrays.fill(cache[i], -1);
    }

    int ret = MX;
    for (int time = 1; time <= totalTime; time++) {
      int maxExp = solve(0, time);
      if (maxExp >= m) {
        ret = Math.min(ret, time);
      }
    }

    return ret == MX ? -1 : ret;
  }

  private static int solve(int idx, int leftTime) {
    if (idx == n) {
      return 0;
    }

    if (cache[idx][leftTime] != -1) {
      return cache[idx][leftTime];
    }

    int ret = solve(idx + 1, leftTime);

    if (leftTime - t[idx] >= 0) {
      ret = Math.max(ret, solve(idx + 1, leftTime - t[idx]) + e[idx]);
    }

    return cache[idx][leftTime] = ret;
  }
}
