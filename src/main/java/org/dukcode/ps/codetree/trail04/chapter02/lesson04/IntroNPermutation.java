package org.dukcode.ps.codetree.trail04.chapter02.lesson04;

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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-n-permutation/description">LINK</a>
 */
public class IntroNPermutation {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static boolean[] taken;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    taken = new boolean[n];

    solve();

    br.close();
    bw.close();

  }

  private static void solve() throws IOException {
    List<Integer> seq = new ArrayList<>();
    solve(seq);
  }

  private static void solve(List<Integer> seq) throws IOException {
    if (seq.size() == n) {
      for (Integer num : seq) {
        bw.write(String.valueOf(num));
        bw.write(' ');
      }
      bw.newLine();
      return;
    }

    for (int num = 1; num <= n; ++num) {
      if (taken[num - 1]) {
        continue;
      }
      seq.add(num);
      taken[num - 1] = true;
      solve(seq);
      seq.remove(seq.size() - 1);
      taken[num - 1] = false;
    }
  }
}
