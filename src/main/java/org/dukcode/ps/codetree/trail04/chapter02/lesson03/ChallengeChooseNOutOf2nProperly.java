package org.dukcode.ps.codetree.trail04.chapter02.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-choose-n-out-of-2n-properly/description">LINK</a>
 */
public class ChallengeChooseNOutOf2nProperly {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] arr;
  private static int total;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    arr = new int[2 * n];
    total = 0;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 2 * n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      total += arr[i];
    }

    bw.write(String.valueOf(solve(-1, 0, 0)));

    br.close();
    bw.close();

  }

  private static int solve(int lastIdx, int cnt, int sum) {
    if (cnt == n) {
      return Math.abs(total - sum - sum);
    }

    int ret = Integer.MAX_VALUE;
    for (int idx = lastIdx + 1; idx < 2 * n; idx++) {
      ret = Math.min(ret, solve(idx, cnt + 1, sum + arr[idx]));
    }

    return ret;
  }
}
