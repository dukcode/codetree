package org.dukcode.ps.codetree.trail04.chapter06.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-pattern-matching/description">LINK</a>
 */
public class ChallengePatternMatching {

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static String s;
  private static String p;
  private static int[][] cache;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    s = br.readLine();
    p = br.readLine();

    bw.write(solve());

    br.close();
    bw.close();
  }

  private static String solve() {

    cache = new int[s.length() + 1][p.length() + 1];
    for (int[] line : cache) {
      Arrays.fill(line, -1);
    }

    return solve(0, 0) == 1 ? "true" : "false";
  }

  private static int solve(int sIdx, int pIdx) {
    if (sIdx == s.length()) {
      if (pIdx == p.length()) {
        return 1;
      }

      return (pIdx < p.length() - 1 && p.charAt(pIdx + 1) == '*') ? solve(sIdx, pIdx + 2) : 0;
    }

    if (pIdx == p.length()) {
      return 0;
    }

    if (cache[sIdx][pIdx] != -1) {
      return cache[sIdx][pIdx];
    }

    int ret = 0;
    if (pIdx < p.length() - 1 && p.charAt(pIdx + 1) == '*') {
      ret = ret | solve(sIdx, pIdx + 2);
      if (s.charAt(sIdx) == p.charAt(pIdx) || p.charAt(pIdx) == '.') {
        ret = ret | solve(sIdx + 1, pIdx);
      }
    } else if (p.charAt(pIdx) == '.' || p.charAt(pIdx) == s.charAt(sIdx)) {
      ret = solve(sIdx + 1, pIdx + 1);
    }

    return cache[sIdx][pIdx] = ret;
  }
}
