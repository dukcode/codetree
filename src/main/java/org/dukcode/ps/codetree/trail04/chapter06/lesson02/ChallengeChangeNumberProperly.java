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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-change-number-properly/description">LINK</a>
 */
public class ChallengeChangeNumberProperly {

  private static final int MN = -987_654_321;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int[] arr;

  private static int[][][] cache;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

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
    // arr과 같은 위치에 같은 원소가 나온 횟수 -> 유사도
    // 인접한 두 수가 다를 횟수가 m 이하인 수열 중에 나올 수 있는 최대 유사도
    cache = new int[n][5][m + 1];
    for (int i = 0; i < n; i++) {
      for (int num = 1; num <= 4; num++) {
        Arrays.fill(cache[i][num], -1);
      }
    }

    int ret = 0;
    for (int num = 1; num <= 4; ++num) {
      ret = Math.max(ret, solve(0, num, m));
    }

    return ret;
  }

  private static int solve(int idx, int num, int changeRemain) {
    if (idx == n - 1) {
      return arr[idx] == num ? 1 : 0;
    }

    if (cache[idx][num][changeRemain] != -1) {
      return cache[idx][num][changeRemain];
    }

    int ret = 0;
    int toAdd = arr[idx] == num ? 1 : 0;
    for (int nextNum = 1; nextNum <= 4; ++nextNum) {
      int nextChangeRemain = changeRemain - (num != nextNum ? 1 : 0);

      if (nextChangeRemain < 0) {
        continue;
      }

      ret = Math.max(ret, solve(idx + 1, nextNum, nextChangeRemain) + toAdd);
    }

    return cache[idx][num][changeRemain] = ret;
  }
}
