package org.dukcode.ps.codetree.trail04.chapter02.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-backward-permutation/description">LINK</a>
 */
public class ChallengeBackwardPermutation {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] arr;
  private static boolean[] taken;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    arr = new int[n];

    taken = new boolean[n];
    solve(0);

    br.close();
    bw.close();

  }

  private static void solve(int idx) throws IOException {
    if (idx == n) {
      for (int i = 0; i < n; i++) {
        bw.write(String.valueOf(arr[i]));
        bw.write(' ');
      }
      bw.newLine();
      return;
    }

    for (int num = n; num > 0; --num) {
      if (taken[num - 1]) {
        continue;
      }

      taken[num - 1] = true;
      arr[idx] = num;
      solve(idx + 1);
      taken[num - 1] = false;
    }
  }
}
