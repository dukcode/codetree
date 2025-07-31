package org.dukcode.ps.codetree.trail04.chapter02.lesson01;

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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-n-permutations-of-k-with-repetition/description">LINK</a>
 */
public class IntroNPermutationsOfKWithRepetition {

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

    pick(new ArrayList<>());

    br.close();
    bw.close();

  }

  private static void pick(List<Integer> picked) throws IOException {
    if (picked.size() == n) {
      for (int num : picked) {
        bw.write(String.valueOf(num));
        bw.write(' ');
      }
      bw.newLine();
      return;
    }

    for (int num = 1; num <= k; num++) {
      picked.add(num);
      pick(picked);
      picked.remove(picked.size() - 1);
    }
  }
}
