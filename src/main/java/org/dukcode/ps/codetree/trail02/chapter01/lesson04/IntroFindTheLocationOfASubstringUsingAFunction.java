package org.dukcode.ps.codetree.trail02.chapter01.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-find-the-location-of-a-substring-using-a-function/description">LINK</a>
 */
public class IntroFindTheLocationOfASubstringUsingAFunction {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    bw.write(String.valueOf(br.readLine().indexOf(br.readLine())));

    br.close();
    bw.close();

  }
}
