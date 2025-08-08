package org.dukcode.ps.codetree.trail04.chapter02.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-max-of-xor/description">LINK</a>
 */
public class ChallengeMaxOfXor {

  private static final int MN = -987_654_321;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  private static int[] arr;

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

    bw.write(String.valueOf(solve(0, 0, 0)));

    br.close();
    bw.close();

  }

  private static int solve(int idx, int cnt, int val) {
    if (idx == n) {
      return cnt == m ? val : MN;
    }

    int ret = MN;
    if (n - idx - 1 >= m - cnt) {
      ret = solve(idx + 1, cnt, val);
    }

    if (cnt < m) {
      ret = Math.max(ret, solve(idx + 1, cnt + 1, val ^ arr[idx]));
    }

    return ret;
  }
}
