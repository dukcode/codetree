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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-coin-change/description">LINK</a>
 */
public class IntroCoinChange {

  private static final int MX = 987_654_321;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int[] coins;

  private static int[] cache;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    coins = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      coins[i] = Integer.parseInt(st.nextToken());
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    cache = new int[m + 1];
    Arrays.fill(cache, -1);

    int ret = solve(m);

    return ret == MX ? -1 : ret;
  }

  private static int solve(int sum) {
    if (sum == 0) {
      return 0;
    }

    if (cache[sum] != -1) {
      return cache[sum];
    }

    int ret = MX;
    for (int coin : coins) {
      int sumBefore = sum - coin;
      if (sumBefore < 0) {
        continue;
      }

      int cntBefore = solve(sumBefore);

      if (cntBefore == MX) {
        continue;
      }

      ret = Math.min(ret, cntBefore + 1);
    }

    return cache[sum] = ret;
  }
}
