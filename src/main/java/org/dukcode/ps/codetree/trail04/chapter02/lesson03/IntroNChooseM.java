package org.dukcode.ps.codetree.trail04.chapter02.lesson03;

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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-n-choose-m/description">LINK</a>
 */
public class IntroNChooseM {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    solve(new ArrayList<>());

    br.close();
    bw.close();

  }

  private static void solve(List<Integer> picked) throws IOException {
    if (picked.size() == m) {
      for (int num : picked) {
        bw.write(String.valueOf(num));
        bw.write(' ');
      }
      bw.newLine();
      return;
    }

    int lastNum = picked.isEmpty() ? 0 : picked.get(picked.size() - 1);
    for (int num = lastNum + 1; num <= n; ++num) {
      picked.add(num);
      solve(picked);
      picked.remove(picked.size() - 1);
    }
  }
}
