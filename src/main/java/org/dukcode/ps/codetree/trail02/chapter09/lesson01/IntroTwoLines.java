package org.dukcode.ps.codetree.trail02.chapter09.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-two-lines/description">LINK</a>
 */
public class IntroTwoLines {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int x1;
  private static int x2;
  private static int x3;
  private static int x4;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    x1 = Integer.parseInt(st.nextToken());
    x2 = Integer.parseInt(st.nextToken());
    x3 = Integer.parseInt(st.nextToken());
    x4 = Integer.parseInt(st.nextToken());

    bw.write(x2 < x3 || x4 < x1 ? "nonintersecting" : "intersecting");

    br.close();
    bw.close();

  }
}
