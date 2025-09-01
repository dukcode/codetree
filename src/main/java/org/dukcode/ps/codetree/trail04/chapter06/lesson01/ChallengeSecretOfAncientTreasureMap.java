package org.dukcode.ps.codetree.trail04.chapter06.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-secret-of-ancient-treasure-map/description">LINK</a>
 */
public class ChallengeSecretOfAncientTreasureMap {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int k;
  private static int[] arr;

  private static int[][] cache; // 음수롤 고를 기회가 k번남았고 idx부터 고를 때 고를 수 있는 최대합

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    cache = new int[k + 1][n];
    for (int i = 0; i <= k; i++) {
      Arrays.fill(cache[i], Integer.MIN_VALUE);
    }

    int ret = Integer.MIN_VALUE;
    for (int idx = 0; idx < n; ++idx) {
      ret = Math.max(ret, solve(k, idx));
    }

    return ret;
  }

  private static int solve(int k, int idx) {
    if (idx == n) {
      return 0;
    }

    if (cache[k][idx] != Integer.MIN_VALUE) {
      return cache[k][idx];
    }

    int ret = arr[idx];
    if (arr[idx] >= 0) {
      ret = Math.max(ret, arr[idx] + solve(k, idx + 1));
    } else if (arr[idx] < 0 && k > 0) {
      ret = Math.max(ret, arr[idx] + solve(k - 1, idx + 1));
    }

    return cache[k][idx] = ret;
  }
}
