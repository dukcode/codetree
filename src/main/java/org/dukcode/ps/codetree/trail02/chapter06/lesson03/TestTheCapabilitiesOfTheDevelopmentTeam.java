package org.dukcode.ps.codetree.trail02.chapter06.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-the-capabilities-of-the-development-team/description">LINK</a>
 */
public class TestTheCapabilitiesOfTheDevelopmentTeam {

  private static final int NONE = -1;
  private static final int N = 5;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int[] arr;
  private static int[] taken;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    taken = new int[N];
    Arrays.fill(taken, -1);

    int ans = solve(0);
    bw.write(String.valueOf(ans == Integer.MAX_VALUE ? -1 : ans));

    br.close();
    bw.close();

  }

  private static int solve(int cnt) {
    if (cnt == 5) {
      return minDiff();
    }

    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < N; i++) {
      if (taken[i] != NONE) {
        continue;
      }

      taken[i] = cnt;
      ans = Math.min(ans, solve(cnt + 1));
      taken[i] = NONE;
    }

    return ans;
  }

  private static int minDiff() {
    int a = arr[taken[0]] + arr[taken[1]];
    int b = arr[taken[2]] + arr[taken[3]];
    int c = arr[taken[4]];

    if (a == b || b == c || c == a) {
      return Integer.MAX_VALUE;
    }

    int max = a;
    max = Math.max(max, b);
    max = Math.max(max, c);

    int min = a;
    min = Math.min(min, b);
    min = Math.min(min, c);

    return Math.abs(max - min);
  }
}
