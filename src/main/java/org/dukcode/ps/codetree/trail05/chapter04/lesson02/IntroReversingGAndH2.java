package org.dukcode.ps.codetree.trail05.chapter04.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-reversing-g-and-h-2/description">LINK</a>
 */
public class IntroReversingGAndH2 {

  private static BufferedReader br;
  private static BufferedWriter bw;


  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    char[] word = br.readLine().toCharArray();
    char[] target = br.readLine().toCharArray();

    int cnt = 0;
    for (int idx = n - 1; idx >= 0; --idx) {

      if (cnt % 2 == 0 && word[idx] == target[idx] || cnt % 2 == 1 && word[idx] != target[idx]) {
        continue;
      }

      cnt++;
    }

    bw.write(String.valueOf(cnt));

    br.close();
    bw.close();
  }
}
