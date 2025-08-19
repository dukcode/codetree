package org.dukcode.ps.codetree.trail04.chapter05.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-number-of-unique-bst/description">LINK</a>
 */
public class ChallengeNumberOfUniqueBst {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int[] cache;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    cache = new int[n + 1];
    bw.write(String.valueOf(solve(n)));

    br.close();
    bw.close();

  }

  private static int solve(int n) {
    if (n <= 1) {
      return 1;
    }

    if (cache[n] != 0) {
      return cache[n];
    }

    int ret = 0;
    for (int i = 0; i < n; i++) {
      ret += solve(i) * solve(n - 1 - i);
    }

    return cache[n] = ret;
  }

}
