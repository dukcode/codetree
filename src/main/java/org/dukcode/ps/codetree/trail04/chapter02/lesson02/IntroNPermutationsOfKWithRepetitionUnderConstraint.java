package org.dukcode.ps.codetree.trail04.chapter02.lesson02;

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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-n-permutations-of-k-with-repetition-under-constraint/description">LINK</a>
 */
public class IntroNPermutationsOfKWithRepetitionUnderConstraint {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int k;
  private static int n;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    k = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());

    List<Integer> picked = new ArrayList<>();
    solve(picked);

    br.close();
    bw.close();

  }

  private static void solve(List<Integer> picked) throws IOException {
    if (picked.size() == n) {
      for (int num : picked) {
        bw.write(String.valueOf(num));
        bw.write(' ');
      }
      bw.newLine();
      return;
    }

    for (int num = 1; num <= k; num++) {
      int size = picked.size();
      if (size >= 2 && picked.get(size - 1) == num && picked.get(size - 2) == num) {
        continue;
      }

      picked.add(num);
      solve(picked);
      picked.remove(picked.size() - 1);
    }
  }
}
