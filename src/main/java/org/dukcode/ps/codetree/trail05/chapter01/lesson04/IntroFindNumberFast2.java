package org.dukcode.ps.codetree.trail05.chapter01.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-find-number-fast-2/description">LINK</a>
 */
public class IntroFindNumberFast2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static TreeSet<Integer> set;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    set = new TreeSet<>();
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(st.nextToken());
      set.add(num);
    }

    for (int i = 0; i < m; i++) {
      int num = Integer.parseInt(br.readLine());
      bw.write(String.valueOf(set.ceiling(num) == null ? -1 : set.ceiling(num)));
      bw.newLine();
    }

    br.close();
    bw.close();
  }
}
