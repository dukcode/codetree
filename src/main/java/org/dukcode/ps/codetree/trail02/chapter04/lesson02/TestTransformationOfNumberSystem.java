package org.dukcode.ps.codetree.trail02.chapter04.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-transformation-of-number-system/description">LINK</a>
 */
public class TestTransformationOfNumberSystem {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    int fromBase = Integer.parseInt(st.nextToken());
    int toBase = Integer.parseInt(st.nextToken());

    String num = br.readLine();

    bw.write(Integer.toString(Integer.parseInt(num, fromBase), toBase));

    br.close();
    bw.close();

  }
}
