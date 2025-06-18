package org.dukcode.ps.codetree.trail02.chapter08.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-restore-initial-sequence/description">LINK</a>
 */
public class ChallengeRestoreInitialSequence {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] sums;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    sums = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n - 1; i++) {
      sums[i] = Integer.parseInt(st.nextToken());
    }

    List<Integer> ans = solve();

    for (int num : ans) {
      bw.write(String.valueOf(num));
      bw.write(' ');
    }

    br.close();
    bw.close();

  }

  private static List<Integer> solve() {
    Loop:
    for (int start = 1; start <= n; start++) {
      List<Integer> ret = new ArrayList<>();
      boolean[] taken = new boolean[n + 1];
      ret.add(start);
      for (int i = 0; i < n - 1; ++i) {
        int now = sums[i] - ret.get(ret.size() - 1);
        if (now <= 0 || now > n || taken[now]) {
          continue Loop;
        }

        taken[now] = true;
        ret.add(now);
      }

      return ret;
    }
    return new ArrayList<>();
  }
}
